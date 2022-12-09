package creatures.behavior;

import creatures.Short;
import item.Essence;

abstract public class Behavior {
    public static void think(Short creature, Essence object) {
        System.out.println(creature.toString() + " is thinking about " + "(" + object.getItemProblem() + ")");
    }

    public static void getDescriptionBehavior() {
        System.out.println("Shorties quarrel ,make peace,be friends");
    }


    public static void understand(Short f, Short s, String idea) {
        System.out.println(f.toString() + " and  " + s.toString() + "understand " + idea);

    }

    public static void say(Short f, String idea) {
        System.out.println(f.toString() + " assume that " + idea);
    }


}
