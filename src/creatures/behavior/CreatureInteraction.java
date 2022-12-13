package creatures.behavior;

import creatures.Shorty;
import item.Essence;

abstract public class CreatureInteraction {
    public void shareThoughts(Shorty first, Shorty second) {
        System.out.println(first + " share thoughts " + "with " + second);
    }

    public void ask(Shorty f, Shorty s, Essence essence) {
        System.out.println(f + " asks " + s + " about " + essence.getItemType() + " " + essence);
    }

    public void becomeFriends(Shorty first, Shorty second) {
        System.out.println(first.toString() + " be friends  " + "with" + second.toString());

        first.getRelationship().addFriends(second);
        second.getRelationship().addFriends(first);

    }

    public  void showRespect(Shorty f, String description) {
        System.out.println(f + " got respect " + description);

    }

    public  void arguing(Shorty f, Shorty s) {
        System.out.println(f + "  argue with  " + s);
    }

    public  void discuss(Shorty f, Shorty s, Essence object) {
        System.out.println(f + " and " + s + " discuss " + object + ":" + object.getItemType());
    }

}
