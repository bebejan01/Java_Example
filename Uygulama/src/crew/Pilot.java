package crew;

import modules.Module;
import util.Severity;

/**
 * Pilot manages navigation and station orientation.
 */
public class Pilot extends CrewMember {
    public Pilot(String name) {
        super(name, 2);
    }

    public Pilot(String name, int skillLevel) {
        super(name, skillLevel);
    }

    @Override
    public void respondToEmergency(Module target, Severity severity) {
        performAction("Adjusting orbit for " + target.getName());
        System.out.println(getName() + " keeps station stable during " + severity + " alarms.");
    }
}
