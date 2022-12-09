import collection.Collection;
import creatures.Short;
import creatures.ShortIdentity;
import creatures.behavior.Feelings;
import creatures.behavior.Relationship;
import item.Energy;
import item.Essence;
import work.Job;
import work.Work;
import work.WorkCondition;

import java.util.Comparator;

import static creatures.behavior.Behavior.*;
import static creatures.behavior.CreatureInteraction.*;


public class Main {

    public static void main(String... args) {

        Short cleverest = Short.createShort("Smartest");
        cleverest.setJob(Job.CLEVEREST);
        Work work1 = new Work.WorkBuilder(WorkCondition.SlOW).setWorkType("Developing nodes").setCreature(cleverest).build();
        Short constructors = Short.createShort("Builders");
        constructors.setJob(Job.WORKER);
        Work work2 = new Work.WorkBuilder(WorkCondition.FAST).setWorkType("Developing nodes").setCreature(constructors).build();
        Energy energy = new Energy(14, "Interaction  two different types of energy:magnetic with moonstone energy", "Магнитная");
        Short scientist = Short.createShort("professor X");
        scientist.setJob(Job.SCIENTIST);
        Essence someStaff = new Essence("scientific problems");
        cleverest.setEmotions(Feelings.ANGRY);

        work1.describeWork();
        cleverest.describeEmotion();


        work1.compareWork(work2);

        cleverest.behaveMediator.action(p -> think(p, energy), cleverest);
        cleverest.behaveMediator.action(p -> becomeFriends(p, scientist), cleverest);
        cleverest.behaveMediator.action(p -> shareThoughts(p, scientist), cleverest);

        getDescriptionBehavior();
        cleverest.behaveMediator.action(p -> discuss(p, scientist, someStaff), cleverest);
        cleverest.behaveMediator.action(p -> arguing(p, scientist), cleverest);
        cleverest.behaveMediator.action(p -> showRespect(p, scientist), cleverest);
        cleverest.behaveMediator.action(p -> understand(p, scientist, "science arguing-normal "), cleverest);
        cleverest.behaveMediator.action(p -> say(p, "it is ok to argue in science"), scientist);


        Collection<Short> collection = new Collection<>();
        collection.add(cleverest);
        collection.add(constructors);
        System.out.println();
        collection.getStream().forEach(x -> x.behaveMediator.actionRelationShip(Relationship::getAllFriends, x));
        collection.getStream().sorted().forEach(a -> System.out.println(a.toString() + "{Uniqueness-" + a.getUniqueness() + "}"));
        collection.getStream().sorted(Comparator.comparingInt(ShortIdentity::getIq)).forEach(a -> System.out.println(a + "{Iq-" + a.getIq() + "}"));
        collection.getStream().sorted(Comparator.comparingInt(ShortIdentity::getStrength)).forEach(a -> System.out.println(a + "{Strength-" + a.getStrength() + "}"));
        collection.getStream().sorted(Comparator.comparingInt(ShortIdentity::getMagicPower)).forEach(a -> System.out.println(a + "{MagicPower-" + a.getMagicPower() + "}"));
    }


}