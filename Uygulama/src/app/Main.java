package app;

import core.EmergencySimulator;
import core.OrbitalStation;
import crew.Engineer;
import crew.Medic;
import crew.Pilot;
import java.util.Locale;
import java.util.Scanner;
import modules.CommunicationModule;
import modules.LifeSupportModule;
import modules.PowerModule;
import util.Severity;

/**
 * Entry point for the Orbital Station Emergency Simulation.
 */
public class Main {
    public static void main(String[] args) {
        OrbitalStation station = new OrbitalStation();
        station.addModule(new LifeSupportModule());
        station.addModule(new PowerModule());
        station.addModule(new CommunicationModule());

        station.addCrewMember(new Engineer("Ada"));
        station.addCrewMember(new Medic("Kenan"));
        station.addCrewMember(new Pilot("Selin"));

        EmergencySimulator simulator = new EmergencySimulator();
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        boolean running = true;
        while (running) {
            printMenu();
            String input = scanner.nextLine().trim();
            switch (input) {
                case "1":
                    System.out.println("--- Station Status ---");
                    System.out.println(station.getStatusReport());
                    break;
                case "2":
                    station.triggerEmergency();
                    break;
                case "3":
                    Severity selected = readSeverity(scanner);
                    if (selected != null) {
                        station.triggerEmergency(selected);
                    }
                    break;
                case "4":
                    simulator.respondWithCrew(station);
                    break;
                case "5":
                    simulator.repairModules(station);
                    break;
                case "0":
                    running = false;
                    System.out.println("Simulation ended.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n--- Orbital Station Emergency Sim ---");
        System.out.println("1) Show station status");
        System.out.println("2) Trigger random emergency");
        System.out.println("3) Trigger emergency with severity");
        System.out.println("4) Respond with crew");
        System.out.println("5) Repair modules");
        System.out.println("0) Exit");
        System.out.print("Select: ");
    }

    private static Severity readSeverity(Scanner scanner) {
        System.out.print("Enter severity (LOW, MEDIUM, HIGH): ");
        String value = scanner.nextLine().trim().toUpperCase(Locale.US);
        try {
            return Severity.valueOf(value);
        } catch (IllegalArgumentException ex) {
            System.out.println("Invalid severity.");
            return null;
        }
    }
}
