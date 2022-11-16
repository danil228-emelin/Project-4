import creatures.Short;
import creatures.behavior.Emotions;
import item.Energy;
import item.Essence;
import work.*;
import myCollection.MyCollection;
import static work.Job.CreatureType;
import static work.Job.startWork;
import static creatures.behavior.Behavior.*;
import java.util.Comparator;


public class Main {

    public static void main(String... args) {

        Short cleverest = new Short("Знайка");
        cleverest.action(p->startWork(p,CreatureType.CLEVEREST));
        Work work1 = new Work("Разработка отдельных узлов", cleverest);
        Short constructors = new Short("Конструкторы");
        constructors.action(p->startWork(p,CreatureType.СONSTRUCTORS));
        Work work2 = new Work("Разработка отдельных узлов", constructors);
        Energy energy = new Energy(14, "Взаимодействие двух разных видов энергии:магнитной с энергией лунного камня", "Магнитная");
        Short scientist = new Short("профессор Звездочкин");
        scientist.action(p->startWork(p,CreatureType.SCIENTIST));
        Essence someStaff = new Essence("научные проблемы");
        cleverest.action(p->Emotions.setEmotion(p, Emotions.Feeling.ANGRY));
        work1.workActions(p -> WorkAction.setWorkCondition(p, Work.WorkCondition.SlOW));
        work1.workActions(WorkAction::describeWork);
        cleverest.action(Emotions::describeEmotion);


        work1.workActions(p -> WorkAction.compareWork(p, work2));
        cleverest.action(p->think(p,energy));
        cleverest.action(p->becomeFriends(p,scientist));
        cleverest.action(p->shareThoughts(p,scientist));
        getDescriptionBehavior();
        cleverest.action(p->discuss(p,scientist,someStaff));
        cleverest.action(p->arguing(p,scientist));
        cleverest.action(p->showRespect(p,scientist));
        cleverest.action(p->understand(p,scientist,"в науке без споров никуда"));

        scientist.action(p->say(p,"без споров в науке никуда"));

        MyCollection<Short> collection = new MyCollection<>();
        collection.add(cleverest);
        collection.add(constructors);
        System.out.println();
        collection.getStream().forEach(x -> x.actionRelationShip(l->l.getAllFriends()));
        collection.getStream().sorted().forEach(a -> System.out.println(a.toString() + "{Uniqueness-" + a.getUniqueness() + "}"));
        collection.getStream().sorted(Comparator.comparingInt(Short::getIq)).forEach(a -> System.out.println(a + "{Iq-" + a.getIq() + "}"));
        collection.getStream().sorted(Comparator.comparingInt(Short::getStrength)).forEach(a -> System.out.println(a + "{Strength-" + a.getStrength() + "}"));
        collection.getStream().sorted(Comparator.comparingInt(Short::getMagicPower)).forEach(a -> System.out.println(a + "{MagicPower-" + a.getMagicPower() + "}"));

    }


}