package creatures.behavior;

import creatures.Short;
import item.Essence;

abstract public class CreatureInteraction {
    public static void shareThoughts(Short first, Short second) {
        System.out.println(first.toString() + " share thoughts " + "(" + second.toString() + ")");
    }


    public static void becomeFriends(Short first, Short second) {
        System.out.println(first.toString() + " be friends  " + "(" + second.toString() + ")");

        first.Behave.actionRelationSheep(x -> x.addFriends(second), first);
        second.Behave.actionRelationSheep(x -> x.addFriends(first), second);

    }

    public static void showRespect(Short f, Short s) {
        System.out.println(f.toString() + " respect " + s.toString());

    }

    public static void arguing(Short f, Short s) {
        System.out.println(f.toString() + "  argue with  " + s.toString());
    }

    public static void discuss(Short f, Short s, Essence object) {
        System.out.println(f.toString() + " and " + s.toString() + " discuss " + object.getItemName());
    }

}
