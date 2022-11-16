package creatures.behavior;
import creatures.Short;
import item.Essence;

abstract public class Behavior extends CreatureInteraction {
    public static void think(Short creature, Essence object){
        System.out.println(creature.toString()+" размышляет о проблеме"+"("+object.getItemProblem()+")");
    }
   public static void getDescriptionBehavior(){
     System.out.println("Коротышки ссорятьться,потом миряться,дружат и так по кругу");
    }


    public static void understand(Short f, Short s, String idea){
        System.out.println(f.toString()+" и "+s.toString()+" понимают,что "+idea);

    }

    public static void say(Short f, String idea){
        System.out.println(f.toString()+" полагает,что "+idea);
    }


}
