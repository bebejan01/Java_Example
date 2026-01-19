package crew;

import modules.Module;
import util.Severity;

/**
 * Engineer specializes in technical repairs.
 */
public class Engineer extends CrewMember {
    public Engineer(String name) {
        super(name, 3);
    }

    public Engineer(String name, int skillLevel) {
        super(name, skillLevel);
    }

    @Override
    public void respondToEmergency(Module target, Severity severity) {
        performAction("Repairing systems on " + target.getName());
        System.out.println(getName() + " prioritizes diagnostics for " + severity + " issues.");
    }
}
