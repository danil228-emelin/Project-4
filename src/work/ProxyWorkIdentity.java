package work;

public class ProxyWorkIdentity {
    private final WorkIdentity job;

    protected ProxyWorkIdentity(WorkIdentity j) {
        job = j;
        job.workEfficiency =
                (!job.creature.toString().equals(Job.WORKER.toString())) ?
                        (int) (Math.random() * 5) + 1 : (int) (Math.random() * 91) + 10;

    }

    public void describeWork() {
        System.out.println(job.creature + " work(" + job.workType + ")" + "," + job.workCondition.getAttitude());
    }


    public void compareWork(ProxyWorkIdentity over) {
        if (job.workEfficiency > over.job.workEfficiency && job.workType.equals(over.job.workType)) {
            System.out.println(job.creature.toString() + " makes work better + " + "(" + job.workType + ") than" + over.job.creature.toString());
        } else {
            System.out.println(over.job.creature.toString() + " makes work better " + "(" + job.workType + ") than " + job.creature.toString());
        }
    }

}




