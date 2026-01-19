package modules;

import util.Severity;

/**
 * Handles energy distribution and power stability.
 */
public class PowerModule extends Module {
    private int powerStability;

    public PowerModule() {
        this("Power Core", MAX_INTEGRITY, 12, 100);
    }

    public PowerModule(String name, int integrity, int energyCost, int powerStability) {
        super(name, integrity, energyCost);
        this.powerStability = powerStability;
    }

    public int getPowerStability() {
        return powerStability;
    }

    @Override
    public void handleEmergency(Severity severity) {
        int damage = 6;
        if (severity == Severity.MEDIUM) {
            damage = 14;
        } else if (severity == Severity.HIGH) {
            damage = 24;
        }
        integrity = Math.max(0, integrity - damage);
        powerStability = Math.max(0, powerStability - (damage + 5));
        logEvent("Power stability dropped to: " + powerStability);
    }

    @Override
    public void repair() {
        super.repair();
        powerStability = Math.min(100, powerStability + 10);
        logEvent("Power stability improved.");
    }
}
