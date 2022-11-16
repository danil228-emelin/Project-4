package work;
import creatures.Short;
public class WorkAction {

    public static void describeWork(Work job) {
        System.out.println(job.creature.toString() + " делает работу(" + job.workType + ")" + "," + job.workCondition.getAttitude());
    }

    public static void setWorkCondition(Work job, Work.WorkCondition condition) {
        job.workCondition = condition;
    }

    public static void compareWork(Work f, Work over) {

        if (f.workEfficiency > over.workEfficiency && f.workType == over.workType) {
            System.out.println(f.creature.toString() + " делают работу лучше  и быстрее " + "(" + f.workType + ") чем " + over.creature.toString());
        } else {
            System.out.println(over.creature.toString() + " делают работу лучше  и быстрее " + "(" + f.workType + ") чем " + f.creature.toString());
        }
    }

    protected static void calculateWorkEfficiency(Work job) {
        job.workEfficiency =
                (job.creature.toString() != Job.CreatureType.СONSTRUCTORS.toString()) ?
                        (int) (Math.random() * 5) + 1 : (int) (Math.random() * 91) + 10;
    }
}




