package creatures.behavior;

import analyze.Analyzer;
import annotations.description_method.MethodDescription;
import creatures.Shorty;
import item.Essence;

import java.util.function.Consumer;

public class Behavior extends CreatureInteraction  {
   private Behavior(){}
    private static Behavior behavior = new Behavior();

    public static Behavior getBehavior() {
        return behavior;
    }

    @MethodDescription(item = "moonstone is  common substance on the moon and its reserves must be  significant")
    public  void makeConclusion(Shorty shorty) {
        System.out.println(shorty + " made conclusion:" + Analyzer.
                getAnalyzer().analyzeMethodDescription("makeConclusion", Behavior.class, Shorty.class));
    }
    @MethodDescription(item = "moonstone will be useful on Earth as on Moon")
    public  void hope(Shorty shorty) {
        System.out.println(shorty + " hope:" + Analyzer.
                getAnalyzer().analyzeMethodDescription("hope", Behavior.class, Shorty.class));
    }
    public  void calculate(Shorty shorty) {
        System.out.println(shorty + " made necessary calculations");
    }

    public  void think(Shorty creature, Essence object) {
        System.out.println(creature.toString() + " is thinking about " + object + " " + object.getItemDescription());
    }

    public  static void getDescriptionBehavior() {
        System.out.println("Shorties quarrel ,make peace,be friends");
    }


    public  void understand(Shorty f, Shorty s, String idea) {
        System.out.println(f.toString() + " and  " + s.toString() + " understand " + idea);

    }

    public  void say(Shorty f, String idea) {
        System.out.println(f + " assume that " + idea);
    }

    @MethodDescription(item = "Geology")
    @MethodDescription(item = "Mineralogy")
    @MethodDescription(item = "Crystallography")
    public  void matchFacts(Shorty shorty) {


        System.out.println(shorty + " think over facts from " + Analyzer.getAnalyzer().
                analyzeMethodDescription("matchFacts", Behavior.class, Shorty.class));

    }

    @MethodDescription(item = "facts about moonstone")
    @MethodDescription(item = "circumstances,where moonstone was found")
    public  void get(Shorty shorty) {
        System.out.println(shorty + " got " + Analyzer.getAnalyzer().
                analyzeMethodDescription("get", Behavior.class, Shorty.class));
    }

    public void looseAbility(Shorty shorty, Essence essence, String reason) {
        System.out.println(shorty + " can't investigate " + essence + " as  " + reason);
    }




}


