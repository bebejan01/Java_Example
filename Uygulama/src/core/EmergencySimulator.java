package core;

import crew.CrewMember;
import modules.Module;
import util.InsufficientResourceException;
import util.Severity;

/**
 * Orchestrates emergency responses and repairs.
 */
public class EmergencySimulator {
    public void respondWithCrew(OrbitalStation station) {
        Module target = station.findWeakestModule();
        if (target == null) {
            System.out.println("No module available for crew response.");
            return;
        }

        Severity severity = station.getLastSeverity();
        if (severity == null) {
            severity = Severity.MEDIUM;
        }

        for (CrewMember member : station.getCrew()) {
            member.respondToEmergency(target, severity);
            int effort = member.getSkillLevel() * 4;
            try {
                station.repairModule(target, effort);
            } catch (InsufficientResourceException e) {
                System.out.println("Crew repair halted: " + e.getMessage());
                break;
            }
        }
    }

    public void repairModules(OrbitalStation station) {
        for (Module module : station.getModules()) {
            try {
                if (module.getIntegrity() < Module.CRITICAL_THRESHOLD) {
                    station.repairModule(module, 20);
                } else {
                    station.repairModule(module);
                }
            } catch (InsufficientResourceException e) {
                System.out.println("Repair skipped: " + e.getMessage());
            }
        }
    }
}
