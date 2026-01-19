package modules;

import util.Severity;

/**
 * Base class for all station modules.
 */
public class Module {
    public static final int MAX_INTEGRITY = 100;
    public static final int CRITICAL_THRESHOLD = 30;

    private final String id;
    private String name;
    protected int integrity;
    private int energyCost;

    public Module() {
        this("Generic Module", MAX_INTEGRITY, 5);
    }

    public Module(String name, int integrity, int energyCost) {
        this.id = "MOD-" + System.nanoTime();
        this.name = name;
        this.integrity = Math.min(integrity, MAX_INTEGRITY);
        this.energyCost = energyCost;
    }

    public final String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getIntegrity() {
        return integrity;
    }

    public int getEnergyCost() {
        return energyCost;
    }

    public void handleEmergency(Severity severity) {
        int damage = 5;
        switch (severity) {
            case MEDIUM:
                damage = 12;
                break;
            case HIGH:
                damage = 20;
                break;
            default:
                break;
        }
        integrity = Math.max(0, integrity - damage);
        logEvent("Emergency handled with damage: " + damage);
    }

    public void repair() {
        repair(10);
    }

    public void repair(int effort) {
        integrity = Math.min(MAX_INTEGRITY, integrity + effort);
        logEvent("Module repaired by effort: " + effort);
    }

    protected void logEvent(String message) {
        System.out.println("[" + name + "] " + message);
    }
}
