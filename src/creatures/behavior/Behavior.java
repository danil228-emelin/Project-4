package creatures.behavior;

import creatures.Shorty;
import item.Essence;

import java.util.function.Consumer;

 public class Behavior extends CreatureInteraction implements Behave{


    public static void think(Shorty creature, Essence object) {
        System.out.println(creature.toString() + " is thinking about " + "(" + object.getItemProblem() + ")");
    }

    public static void getDescriptionBehavior() {
        System.out.println("Shorties quarrel ,make peace,be friends");
    }


    public static void understand(Shorty f, Shorty s, String idea) {
        System.out.println(f.toString() + " and  " + s.toString() + "understand " + idea);

    }

    public static void say(Shorty f, String idea) {
        System.out.println(f.toString() + " assume that " + idea);
    }


public void action (Consumer<Shorty> move, Shorty shorty){move.accept(shorty);}

     public void actionRelationSheep (Consumer<Relationship> move, Shorty shorty){move.accept(shorty.getRelationship());}

}


