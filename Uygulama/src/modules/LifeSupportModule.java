package modules;

import util.Severity;

/**
 * Manages oxygen and life support.
 */
public class LifeSupportModule extends Module {
    private int oxygenFlowRate;

    public LifeSupportModule() {
        this("Life Support", MAX_INTEGRITY, 8, 100);
    }

    public LifeSupportModule(String name, int integrity, int energyCost, int oxygenFlowRate) {
        super(name, integrity, energyCost);
        this.oxygenFlowRate = oxygenFlowRate;
    }

    public int getOxygenFlowRate() {
        return oxygenFlowRate;
    }

    @Override
    public void handleEmergency(Severity severity) {
        int damage = 8;
        if (severity == Severity.MEDIUM) {
            damage = 15;
        } else if (severity == Severity.HIGH) {
            damage = 25;
        }
        integrity = Math.max(0, integrity - damage);
        oxygenFlowRate = Math.max(0, oxygenFlowRate - damage);
        logEvent("Oxygen system strained, flow now: " + oxygenFlowRate);
    }

    @Override
    public void repair(int effort) {
        super.repair(effort + 5);
        oxygenFlowRate = Math.min(100, oxygenFlowRate + effort);
        logEvent("Oxygen flow stabilized.");
    }
}
