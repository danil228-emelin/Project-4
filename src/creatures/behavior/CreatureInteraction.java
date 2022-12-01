package creatures.behavior;

import creatures.Short;
import item.Essence;

abstract public class CreatureInteraction {
    public static void shareThoughts(Short first, Short second){
        System.out.println(first.toString()+" share thoughts "+"("+second.toString()+")");
    }

    public static void quarrel(Short first, Short second){
        System.out.println(first.toString()+" quarrel with "+"("+second.toString()+")");
        first.actionRelationShip(p->p.addRivals(second));
        second.actionRelationShip(p->p.addRivals(first));
    }

    public static void putUp(Short first, Short second){
        first.actionRelationShip(p->p.addFriends(second));
        second.actionRelationShip(p->p.addFriends(first));
        System.out.println(first.toString()+" make peace "+"("+second.toString()+")");

    }

    public static void becomeFriends(Short first, Short second){
        System.out.println(first.toString()+" be friends  "+"("+second.toString()+")");
        first.actionRelationShip(p->p.addFriends(second));
        second.actionRelationShip(p->p.addFriends(first));

    }

    public static void showRespect(Short f, Short s){
        System.out.println(f.toString()+" respect "+s.toString());

    }
    public static void arguing(Short f , Short s){
        System.out.println(f.toString()+"  argue with  "+s.toString());
    }

    public static void discuss(Short f, Short s, Essence object){
        System.out.println(f.toString()+" and "+s.toString()+" discuss "+object.getItemName());
    }

}
