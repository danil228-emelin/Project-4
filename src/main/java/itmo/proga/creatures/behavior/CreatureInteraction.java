package itmo.proga.creatures.behavior;

import itmo.proga.annotations.creature_interaction.CreaturesInteraction;
import itmo.proga.creatures.Shorty;
import itmo.proga.item.Essence;

abstract public class CreatureInteraction {

    @CreaturesInteraction(firstCreature = "Smartest", secondCreature = "Professor X")
    public static void shareThoughts(Shorty first, Shorty second) {
        System.out.println(first + " share thoughts " + "with " + second);
    }

    public static void ask(Shorty f, Shorty s, Essence essence) {
        System.out.println(f + " asks " + s + " about " + essence.getItemType() + " " + essence);
    }

    public static void becomeFriends(Shorty first, Shorty second) {
        System.out.println(first.toString() + " be friends  " + "with" + second.toString());

        first.getRelationship().addFriends(second);
        second.getRelationship().addFriends(first);

    }

    public static void showRespect(Shorty f, String description) {
        System.out.println(f + " got respect " + description);

    }

    public static void arguing(Shorty f, Shorty s) {
        System.out.println(f + "  argue with  " + s);
    }

    public static void discuss(Shorty f, Shorty s, Essence object) {
        System.out.println(f + " and " + s + " discuss " + object + ":" + object.getItemType());
    }

}
