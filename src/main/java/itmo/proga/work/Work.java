package itmo.proga.work;

import itmo.proga.creatures.Shorty;

import java.util.Arrays;


public class Work extends WorkIdentity {
    public String toString(Object[] array) {
        StringBuilder result = new StringBuilder(Arrays.toString(array));
        return result.substring(1, result.length() - 1);
    }

    public void describeWork() {

        System.out.println(toString(creatures) + " do activity (" + workType + ")" + "," + workCondition.getAttitude());
    }


    public void compareWork(Work over) {
        if (workCondition.getEfficiency() > over.workCondition.getEfficiency() && workType.equals(over.workType)) {
            System.out.println(toString(creatures) + " makes com.example.work better + " + "(" + workType + ") than" + toString(creatures));
        } else {
            System.out.println(toString(over.creatures) + " makes com.example.work better " + "(" + workType + ") than " + toString(creatures));
        }
    }

    private Work(WorkBuilder w) {
        workType = w.workType;
        creatures = w.creatures;
        workCondition = w.workCondition;

    }

    public static class WorkBuilder {

        private String workType;

        private Shorty[] creatures;

        private WorkCondition workCondition;

        public WorkBuilder(WorkCondition w) {
            workCondition = w;
        }

        public WorkBuilder setWorkType(String workType) {
            this.workType = workType;
            return this;
        }

        public WorkBuilder setCreatures(Shorty... creatures) {
            this.creatures = creatures;
            return this;
        }


        public Work build() {
            return new Work(this);
        }


    }

    public void makeBoss(Shorty shorty, String activity) {
        System.out.println(toString(creatures) + " make responsible for " + activity + " " + shorty.getJob() + "-" + shorty);
    }

}