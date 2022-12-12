package main;

import analyze.Analyzer;
import collection.Collection;
import creatures.ShortIdentity;
import creatures.Shorty;
import creatures.behavior.Feelings;
import creatures.behavior.Relationship;
import item.City;
import item.Energy;
import item.Essence;
import item.ScienceCity;
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
        Essence someStaff = new Essence("scientific problems");
        cleverest.setEmotions(Feelings.ANGRY);

        developingNodes.describeWork();
        cleverest.describeEmotion();
        developingNodes.compareWork(developingNodes2);
        Shorty.Behave.action(p -> think(p, energy), cleverest);
        Shorty.Behave.action(p -> becomeFriends(p, scientist), cleverest);
        Shorty.Behave.action(p -> shareThoughts(p, scientist), cleverest);
        getDescriptionBehavior();
        Shorty.Behave.action(p -> discuss(p, scientist, someStaff), cleverest);
        Shorty.Behave.action(p -> arguing(p, scientist), cleverest);
        Shorty.Behave.action(p -> showRespect(p, scientist), cleverest);
        Shorty.Behave.action(p -> understand(p, scientist, "science arguing-normal "), cleverest);
        Shorty.Behave.action(p -> say(p, "it is ok to argue in science"), scientist);


        Collection<Shorty> collection = new Collection<>();
        collection.add(cleverest);
        collection.add(constructors);
        System.out.println();
        collection.getStream().forEach(x -> Shorty.Behave.actionRelationSheep(Relationship::getAllFriends, x));
        collection.getStream().sorted().forEach(a -> System.out.println(a.toString() + "{Uniqueness-" + a.getUniqueness() + "}"));
        collection.getStream().sorted(Comparator.comparingInt(ShortIdentity::getIq)).forEach(a -> System.out.println(a + "{Iq-" + a.getIq() + "}"));
        collection.getStream().sorted(Comparator.comparingInt(ShortIdentity::getStrength)).forEach(a -> System.out.println(a + "{Strength-" + a.getStrength() + "}"));
        collection.getStream().sorted(Comparator.comparingInt(ShortIdentity::getMagicPower)).forEach(a -> System.out.println(a + "{MagicPower-" + a.getMagicPower() + "}"));
        System.out.println();

        ScienceCity scienceCity = new ScienceCity();

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

    }

}