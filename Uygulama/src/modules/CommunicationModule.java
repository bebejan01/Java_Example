package modules;

import util.Severity;

/**
 * Maintains antenna and communication systems.
 */
public class CommunicationModule extends Module {
    private int signalStrength;

    public CommunicationModule() {
        this("Communications", MAX_INTEGRITY, 6, 100);
    }

    public CommunicationModule(String name, int integrity, int energyCost, int signalStrength) {
        super(name, integrity, energyCost);
        this.signalStrength = signalStrength;
    }

    public int getSignalStrength() {
        return signalStrength;
    }

    @Override
    public void handleEmergency(Severity severity) {
        int damage = 4;
        if (severity == Severity.MEDIUM) {
            damage = 10;
        } else if (severity == Severity.HIGH) {
            damage = 18;
        }
        integrity = Math.max(0, integrity - damage);
        signalStrength = Math.max(0, signalStrength - (damage + 3));
        logEvent("Signal strength now: " + signalStrength);
    }

    @Override
    public void repair(int effort) {
        super.repair(effort);
        signalStrength = Math.min(100, signalStrength + (effort / 2));
        logEvent("Antenna realigned.");
    }
}
