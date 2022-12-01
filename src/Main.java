import collection.Collection;
import creatures.Short;
import creatures.ShortIdentity;
import creatures.behavior.Feelings;
import item.Energy;
import item.Essence;
import work.Job;
import work.WorkCondition;
import work.WorkIdentity;
import work.ProxyWorkIdentity;

import java.util.Comparator;

import static creatures.behavior.Behavior.*;


public class Main {

    public static void main(String... args) {

        Short cleverest = Short.createShort("Smartest");
        cleverest.action(p -> p.setJob(Job.CLEVEREST));
        ProxyWorkIdentity work1 = new WorkIdentity.WorkBuilder(WorkCondition.SlOW).setWorkType("Developing nodes").setCreature(cleverest).build();
        Short constructors = Short.createShort("Builders");
        constructors.action(p -> p.setJob(Job.WORKER));
        ProxyWorkIdentity work2 = new WorkIdentity.WorkBuilder(WorkCondition.FAST).setWorkType("Developing nodes").setCreature(constructors).build();
        Energy energy = new Energy(14, "Interaction  two different types of energy:magnetic with moonstone energy", "Магнитная");
        Short scientist = Short.createShort("professor X");
        scientist.action(p -> p.setJob(Job.SCIENTIST));
        Essence someStaff = new Essence("scientific problems");
        cleverest.action(p -> p.setEmotions(Feelings.ANGRY));

        work1.describeWork();
        cleverest.action(Short::describeEmotion);


        work1.compareWork( work2);
        cleverest.action(p -> think(p, energy));
        cleverest.action(p -> becomeFriends(p, scientist));
        cleverest.action(p -> shareThoughts(p, scientist));
        getDescriptionBehavior();
        cleverest.action(p -> discuss(p, scientist, someStaff));
        cleverest.action(p -> arguing(p, scientist));
        cleverest.action(p -> showRespect(p, scientist));
        cleverest.action(p -> understand(p, scientist, "science arguing-normal "));

        scientist.action(p -> say(p, "it is ok to argue in science"));

        Collection<Short> collection = new Collection<>();
        collection.add(cleverest);
        collection.add(constructors);
        System.out.println();
        collection.getStream().forEach(x -> x.actionRelationShip(l -> l.getAllFriends()));
        collection.getStream().sorted().forEach(a -> System.out.println(a.toString() + "{Uniqueness-" + a.getUniqueness() + "}"));
        collection.getStream().sorted(Comparator.comparingInt(ShortIdentity::getIq)).forEach(a -> System.out.println(a + "{Iq-" + a.getIq() + "}"));
        collection.getStream().sorted(Comparator.comparingInt(ShortIdentity::getStrength)).forEach(a -> System.out.println(a + "{Strength-" + a.getStrength() + "}"));
        collection.getStream().sorted(Comparator.comparingInt(ShortIdentity::getMagicPower)).forEach(a -> System.out.println(a + "{MagicPower-" + a.getMagicPower() + "}"));
    }


}