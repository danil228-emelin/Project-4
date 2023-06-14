package itmo.proga;

import itmo.proga.analyze.Analyzer;
import itmo.proga.creatures.Shorty;
import itmo.proga.creatures.behavior.Behavior;
import itmo.proga.creatures.behavior.Feelings;
import itmo.proga.item.*;
import itmo.proga.list.ListCollection;
import itmo.proga.tree.HashTree;
import itmo.proga.work.Job;
import itmo.proga.work.Work;
import itmo.proga.work.WorkCondition;

import java.util.Comparator;

import static itmo.proga.creatures.behavior.Behavior.getDescriptionBehavior;

public class Main {

    public static void main(String... args) {
        Analyzer.getAnalyzer().analyzeCreatureCreation();
        Shorty cleverest = Shorty.shorts.get("Smartest");
        cleverest.setJob(Job.CLEVEREST);
        Work developingNodes = new Work.WorkBuilder(WorkCondition.SlOW).setWorkType("Developing nodes").setCreatures(cleverest).build();
        Shorty constructors = Shorty.shorts.get("Builders");

        constructors.setJob(Job.WORKER);
        Work developingNodes2 = new Work.WorkBuilder(WorkCondition.FAST).setWorkType("Developing nodes").setCreatures(constructors).build();
        Essence energy = new Essence(" energy,").setItemDescription("Interaction  two different types of energy:magnetic with moonstone energy");
        Shorty scientist = Shorty.createShort("professor X");
        scientist.setJob(Job.SCIENTIST);
        Essence someStaff = new Essence("someStaff").setItemDescription("scientific problems");
        cleverest.setEmotions(Feelings.ANGRY);
        developingNodes.describeWork();
        cleverest.describeEmotion();
        developingNodes.compareWork(developingNodes2);
        Behavior.think(cleverest, energy);

        Analyzer.getAnalyzer().analyzeCreatureInteraction("shareThoughts");
        Behavior.becomeFriends(cleverest, scientist);


        Behavior.shareThoughts(cleverest, scientist);

        getDescriptionBehavior();

        Behavior.discuss(cleverest, scientist, someStaff);

        Behavior.arguing(cleverest, scientist);

        Behavior.showRespect(scientist, "");

        Behavior.understand(cleverest, scientist, " science arguing-normal ");

        Behavior.say(scientist, "it is ok to argue in science");


        ListCollection<Shorty> collection = new ListCollection<>();
        collection.add(cleverest);
        collection.add(constructors);
        System.out.println();
        collection.getStream().sorted().forEach(a -> System.out.println(a.toString() + "{Uniqueness-" + a.getUniqueness() + "}"));
        collection.getStream().sorted(Comparator.comparingInt(Shorty::getIq)).forEach(a -> System.out.println(a + "{Iq-" + a.getIq() + "}"));
        collection.getStream().sorted(Comparator.comparingInt(Shorty::getStrength)).forEach(a -> System.out.println(a + "{Strength-" + a.getStrength() + "}"));
        collection.getStream().sorted(Comparator.comparingInt(Shorty::getMagicPower)).forEach(a -> System.out.println(a + "{MagicPower-" + a.getMagicPower() + "}"));
        System.out.println();
        @SuppressWarnings("All")
        City scienceCity = new City("ScienceCity");

        Analyzer analyzer = Analyzer.getAnalyzer();

        analyzer.analyzeCity();

        Shorty fuchsia = Shorty.shorts.get("Fuchsia");

        Shorty herring = Shorty.shorts.get("Herring");

        analyzer.analyzeCity();


        Work sketching = new Work.WorkBuilder(WorkCondition.FINISH).setWorkType("sketching").setCreatures(fuchsia, herring).build();

        sketching.describeWork();

        analyzer.analyzeCity();


        Shorty cr1 = Shorty.shorts.get("Constructor1");
        Shorty cr2 = Shorty.shorts.get("Constructor2");
        Shorty cr3 = Shorty.shorts.get("Constructor3");

        analyzer.analyzeCity();

        Work creatingRocket = new Work.WorkBuilder(WorkCondition.FAST).setWorkType("creating blueprints for a rocket").setCreatures(cr1, cr2, cr3).build();
        creatingRocket.describeWork();

        Blueprint blueprint = (Blueprint) analyzer.analyzeBluePrint();
        blueprint.getDescription();
        @SuppressWarnings("All")
        Factory factory1 = new Factory("factory1");
        @SuppressWarnings("All")
        Factory factory2 = new Factory("factory2");
        Blueprint.send();
        @SuppressWarnings("All")
        City sunCity = new City("SunCity");
        Shorty klepka = Shorty.shorts.get("Klepka");
        klepka.setJob(Job.WORKER);

        sketching.makeBoss(klepka, "monitoring  details' progress");
        analyzer.analyzeCity();
        Car car = analyzer.analyzeCarDescription(klepka, "car");
        car.getDescription();
        Behavior.showRespect(klepka, "as he does a lot");

        Essence moon = new Essence("Moon");
        Essence moonstone = new Essence("Moonstone").setLocation("Moon").
                setItemDescription("as it gives cleverest strength to handle with gravity ").setItemType("all sorts of experiments");
        Behavior.think(scientist, moon);

        Behavior.think(scientist, moonstone);

        Behavior.looseAbility(scientist, moonstone, moonstone.getLocation() + " because of " + cleverest);

        Behavior.ask(scientist, cleverest, moonstone);

        Behavior.get(scientist);

        Behavior.matchFacts(scientist);
        Behavior.calculate(scientist);
        Behavior.makeConclusion(scientist);
        cleverest.setEmotions(Feelings.HAPPY);
        cleverest.describeEmotion();
        Behavior.hope(cleverest);



        HashTree<String, Shorty> collectionTree = new HashTree<>();
        collectionTree.insert(scientist.toString(), scientist);


    }

}