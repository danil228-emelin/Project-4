package main;

import analyze.Analyzer;
import collection.Collection;
import creatures.ShortIdentity;
import creatures.Shorty;
import creatures.behavior.Behavior;
import creatures.behavior.Feelings;
import creatures.behavior.Relationship;
import item.*;
import item.city.City;
import work.Job;
import work.Work;
import work.WorkCondition;

import java.util.Comparator;
import java.util.HashMap;

import static creatures.behavior.Behavior.*;

public class Main {
    public static final HashMap<String, Shorty> shorts = new HashMap<>();


    public static void main(String... args) {

        Shorty cleverest = Shorty.createShort("Smartest");
        cleverest.setJob(Job.CLEVEREST);
        Work developingNodes = new Work.WorkBuilder(WorkCondition.SlOW).setWorkType("Developing nodes").setCreatures(cleverest).build();
        Shorty constructors = Shorty.createShort("Builders");
        constructors.setJob(Job.WORKER);
        Work developingNodes2 = new Work.WorkBuilder(WorkCondition.FAST).setWorkType("Developing nodes").setCreatures(constructors).build();
        Energy energy = new Energy(14, "Interaction  two different types of energy:magnetic with moonstone energy", "Магнитная");
        Shorty scientist = Shorty.createShort("professor X");
        scientist.setJob(Job.SCIENTIST);
        Essence someStaff = new Essence("someStaff").setItemDescription("scientific problems");
        cleverest.setEmotions(Feelings.ANGRY);

        developingNodes.describeWork();
        cleverest.describeEmotion();
        developingNodes.compareWork(developingNodes2);
        Shorty.Behave.think(cleverest,energy);

        Shorty.Behave.becomeFriends(cleverest,scientist);

        Shorty.Behave.shareThoughts(cleverest,scientist);

       getDescriptionBehavior();

        Shorty.Behave.discuss(cleverest,scientist,someStaff);

        Shorty.Behave.arguing(cleverest,scientist);

        Shorty.Behave.showRespect(scientist,"");

        Shorty.Behave.understand(cleverest,scientist," science arguing-normal ");

        Shorty.Behave.say(scientist,"it is ok to argue in science");


        Collection<Shorty> collection = new Collection<>();
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

        Shorty fuchsia = Shorty.createShort("Fuchsia");

        Shorty herring = Shorty.createShort("Herring");

        analyzer.analyzeCity();


        Work sketching = new Work.WorkBuilder(WorkCondition.FINISH).setWorkType("sketching").setCreatures(fuchsia, herring).build();

        sketching.describeWork();

        analyzer.analyzeCity();


        Shorty cr1 = Shorty.createShort("Constructor1");
        Shorty cr2 = Shorty.createShort("Constructor2");
        Shorty cr3 = Shorty.createShort("Constructor3");

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
        Shorty klepka = Shorty.createShort("Klepka");
        klepka.setJob(Job.WORKER);

        sketching.makeBoss(klepka, "monitoring  details' progress");
        analyzer.analyzeCity();
        Car car = analyzer.analyzeCarDescription(klepka, "car");
        car.getDescription();
        Shorty.Behave.showRespect(klepka,"as he does a lot");

        Essence moon = new Essence("Moon");
        Essence moonstone = new Essence("Moonstone").setLocation("Moon").
                setItemDescription("as it gives cleverest strength to handle with gravity ").setItemType("all sorts of experiments");
        Shorty.Behave.think(scientist,moon);

        Shorty.Behave.think(scientist,moonstone);

        Shorty.Behave.looseAbility(scientist,moonstone,moonstone.getLocation()+" becasue of "+cleverest);

        Shorty.Behave.ask(scientist,cleverest,moonstone);

        Shorty.Behave.get(scientist);

        Shorty.Behave.matchFacts(scientist);
        Shorty.Behave.calculate(scientist);
        Shorty.Behave.makeConclusion(scientist);
        cleverest.setEmotions(Feelings.HAPPY);
        cleverest.describeEmotion();
        Shorty.Behave.hope(cleverest);

    }

}