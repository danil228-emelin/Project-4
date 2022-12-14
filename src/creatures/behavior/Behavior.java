package creatures.behavior;

import analyze.Analyzer;
import annotations.description_method.MethodDescription;
import creatures.Shorty;
import item.Essence;

abstract public class Behavior extends CreatureInteraction {


    @MethodDescription(item = "moonstone is  common substance on the moon and its reserves must be  significant")
    public static void makeConclusion(Shorty shorty) {
        System.out.println(shorty + " made conclusion:" + Analyzer.
                getAnalyzer().analyzeMethodDescription("makeConclusion", Behavior.class, Shorty.class));
    }

    @MethodDescription(item = "moonstone will be useful on Earth as on Moon")
    public static void hope(Shorty shorty) {
        System.out.println(shorty + " hope:" + Analyzer.
                getAnalyzer().analyzeMethodDescription("hope", Behavior.class, Shorty.class));
    }

    public static void calculate(Shorty shorty) {
        System.out.println(shorty + " made necessary calculations");
    }

    public static void think(Shorty creature, Essence object) {
        System.out.println(creature.toString() + " is thinking about " + object + " " + object.getItemDescription());
    }

    public static void getDescriptionBehavior() {
        System.out.println("Shorties quarrel ,make peace,be friends");
    }


    public static void understand(Shorty f, Shorty s, String idea) {
        System.out.println(f.toString() + " and  " + s.toString() + " understand " + idea);

    }

    public static void say(Shorty f, String idea) {
        System.out.println(f + " assume that " + idea);
    }

    @MethodDescription(item = "Geology")
    @MethodDescription(item = "Mineralogy")
    @MethodDescription(item = "Crystallography")
    public static void matchFacts(Shorty shorty) {


        System.out.println(shorty + " think over facts from " + Analyzer.getAnalyzer().
                analyzeMethodDescription("matchFacts", Behavior.class, Shorty.class));

    }

    @MethodDescription(item = "facts about moonstone")
    @MethodDescription(item = "circumstances,where moonstone was found")
    public static void get(Shorty shorty) {
        System.out.println(shorty + " got " + Analyzer.getAnalyzer().
                analyzeMethodDescription("get", Behavior.class, Shorty.class));
    }

    public static void looseAbility(Shorty shorty, Essence essence, String reason) {
        System.out.println(shorty + " can't investigate " + essence + " as  " + reason);
    }


}


