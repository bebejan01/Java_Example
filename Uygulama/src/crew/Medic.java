package crew;

import modules.Module;
import util.Severity;

/**
 * Medic focuses on crew safety and life support.
 */
public class Medic extends CrewMember {
    public Medic(String name) {
        super(name, 2);
    }

    public Medic(String name, int skillLevel) {
        super(name, skillLevel);
    }

    @Override
    public void respondToEmergency(Module target, Severity severity) {
        performAction("Stabilizing crew while checking " + target.getName());
        System.out.println(getName() + " monitors oxygen during " + severity + " events.");
    }
}
