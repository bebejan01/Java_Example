package crew;

import modules.Module;
import util.Severity;

/**
 * Base class for all crew members.
 */
public class CrewMember {
    private String name;
    protected int skillLevel;

    public CrewMember(String name) {
        this(name, 1);
    }

    public CrewMember(String name, int skillLevel) {
        this.name = name;
        this.skillLevel = skillLevel;
    }

    public String getName() {
        return name;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void performAction(String action) {
        System.out.println(name + " performs action: " + action);
    }

    public void respondToEmergency(Module target, Severity severity) {
        System.out.println(name + " responds to " + target.getName() + " at " + severity + " severity.");
    }
}
