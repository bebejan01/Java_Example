package core;

import crew.CrewMember;
import modules.CommunicationModule;
import modules.LifeSupportModule;
import modules.Module;
import modules.PowerModule;
import util.InsufficientResourceException;
import util.Severity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents the orbital station with modules, crew, and resources.
 */
public class OrbitalStation {
    private int energy;
    private int oxygen;
    private int hullIntegrity;

    private final List<Module> modules;
    private final List<CrewMember> crew;
    private final Random random;

    private Module lastEmergencyModule;
    private Severity lastSeverity;

    public OrbitalStation() {
        this(120, 100, 100);
    }

    public OrbitalStation(int energy, int oxygen, int hullIntegrity) {
        this.energy = energy;
        this.oxygen = oxygen;
        this.hullIntegrity = hullIntegrity;
        this.modules = new ArrayList<>();
        this.crew = new ArrayList<>();
        this.random = new Random();
    }

    public void addModule(Module module) {
        modules.add(module);
    }

    public void addCrewMember(CrewMember member) {
        crew.add(member);
    }

    public List<Module> getModules() {
        return modules;
    }

    public List<CrewMember> getCrew() {
        return crew;
    }

    public Module getLastEmergencyModule() {
        return lastEmergencyModule;
    }

    public Severity getLastSeverity() {
        return lastSeverity;
    }

    public String getStatusReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("Energy: ").append(energy).append(" | Oxygen: ").append(oxygen)
                .append(" | Hull: ").append(hullIntegrity).append("\n");
        for (Module module : modules) {
            sb.append("- ").append(module.getName())
                    .append(" (Integrity: ").append(module.getIntegrity())
                    .append(")\n");
        }
        return sb.toString();
    }

    public void triggerEmergency() {
        Severity[] values = Severity.values();
        Severity severity = values[random.nextInt(values.length)];
        triggerEmergency(severity);
    }

    public void triggerEmergency(Severity severity) {
        if (modules.isEmpty()) {
            System.out.println("No modules available to handle emergencies.");
            return;
        }
        lastSeverity = severity;
        lastEmergencyModule = modules.get(random.nextInt(modules.size()));
        System.out.println("Emergency detected at " + lastEmergencyModule.getName() + " severity: " + severity);

        for (Module module : modules) {
            module.handleEmergency(severity);
        }

        applyStationWideEffects(severity);
    }

    public void repairModule(Module module) throws InsufficientResourceException {
        repairModule(module, 10);
    }

    public void repairModule(Module module, int effort) throws InsufficientResourceException {
        int requiredEnergy = module.getEnergyCost() + effort;
        consumeEnergy(requiredEnergy);
        module.repair(effort);
    }

    public Module findWeakestModule() {
        Module weakest = null;
        for (Module module : modules) {
            if (weakest == null || module.getIntegrity() < weakest.getIntegrity()) {
                weakest = module;
            }
        }
        return weakest;
    }

    private void applyStationWideEffects(Severity severity) {
        int energyLoss = 5;
        int oxygenLoss = 3;
        int hullLoss = 2;

        if (severity == Severity.MEDIUM) {
            energyLoss = 10;
            oxygenLoss = 6;
            hullLoss = 5;
        } else if (severity == Severity.HIGH) {
            energyLoss = 18;
            oxygenLoss = 12;
            hullLoss = 9;
        }

        energy = Math.max(0, energy - energyLoss);
        oxygen = Math.max(0, oxygen - oxygenLoss);
        hullIntegrity = Math.max(0, hullIntegrity - hullLoss);

        if (lastEmergencyModule instanceof LifeSupportModule) {
            oxygen = Math.max(0, oxygen - 5);
        } else if (lastEmergencyModule instanceof PowerModule) {
            energy = Math.max(0, energy - 5);
        } else if (lastEmergencyModule instanceof CommunicationModule) {
            hullIntegrity = Math.max(0, hullIntegrity - 3);
        }
    }

    private void consumeEnergy(int amount) throws InsufficientResourceException {
        if (energy < amount) {
            throw new InsufficientResourceException("Not enough energy. Required: " + amount + ", Available: " + energy);
        }
        energy -= amount;
    }
}
