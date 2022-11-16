package creatures.behavior;

import creatures.Short;
import item.Essence;

abstract public class CreatureInteraction {
    public static void shareThoughts(Short first, Short second){
        System.out.println(first.toString()+" поделился мыслями с другом "+"("+second.toString()+")");
    }

    public static void quarrel(Short first, Short second){
        System.out.println(first.toString()+" посссорился  с "+"("+second.toString()+")");
        first.actionRelationShip(p->p.addRivals(second));
        second.actionRelationShip(p->p.addRivals(first));
    }

    public static void putUp(Short first, Short second){
        first.actionRelationShip(p->p.addFriends(second));
        second.actionRelationShip(p->p.addFriends(first));
        System.out.println(first.toString()+" помирился "+"("+second.toString()+")");

    }

    public static void becomeFriends(Short first, Short second){
        System.out.println(first.toString()+" подружился с коротышкой "+"("+second.toString()+")");
        first.actionRelationShip(p->p.addFriends(second));
        second.actionRelationShip(p->p.addFriends(first));

    }

    public static void showRespect(Short f, Short s){
        System.out.println(f.toString()+" все еще уважает "+s.toString());

    }
    public static void arguing(Short f , Short s){
        System.out.println(f.toString()+"  спорит с "+s.toString());
    }

    public static void discuss(Short f, Short s, Essence object){
        System.out.println(f.toString()+" и "+s.toString()+" обсуждают "+object.getItemName());
    }

}
