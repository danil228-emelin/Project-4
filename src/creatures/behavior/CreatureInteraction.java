package creatures.behavior;

import creatures.Shorty;
import item.Essence;

abstract public class CreatureInteraction {
    public static void shareThoughts(Shorty first, Shorty second) {
        System.out.println(first.toString() + " share thoughts " + "(" + second.toString() + ")");
    }


    public static void becomeFriends(Shorty first, Shorty second) {
        System.out.println(first.toString() + " be friends  " + "(" + second.toString() + ")");

        first.Behave.actionRelationSheep(x -> x.addFriends(second), first);
        second.Behave.actionRelationSheep(x -> x.addFriends(first), second);

    }

    public static void showRespect(Shorty f, Shorty s) {
        System.out.println(f.toString() + " respect " + s.toString());

    }

    public static void arguing(Shorty f, Shorty s) {
        System.out.println(f.toString() + "  argue with  " + s.toString());
    }

    public static void discuss(Shorty f, Shorty s, Essence object) {
        System.out.println(f.toString() + " and " + s.toString() + " discuss " + object.getItemName());
    }

}
