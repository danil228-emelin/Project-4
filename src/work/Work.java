package work;

import creatures.Short;

public class Work extends WorkIdentity {

       public void describeWork() {
        System.out.println(creature + " work(" + workType + ")" + "," + workCondition.getAttitude());
    }


    public void compareWork(Work over) {
        if (workEfficiency > over.workEfficiency && workType.equals(over.workType)) {
            System.out.println(creature.toString() + " makes work better + " + "(" + workType + ") than" + over.creature.toString());
        } else {
            System.out.println(over.creature.toString() + " makes work better " + "(" + workType + ") than " + creature.toString());
        }
    }

    private  Work(WorkBuilder w){
        workType = w.workType;
        creature = w.creature;
        workCondition = w.workCondition;
    }

    public static class WorkBuilder {

        private String workType;
        private Short creature;

        private WorkCondition workCondition;
        public  WorkBuilder(WorkCondition w){workCondition = w;}
        public WorkBuilder setWorkType(String workType) {
            this.workType = workType;
            return this;
        }

        public WorkBuilder setCreature(Short creature) {
            this.creature = creature;
            return this;
        }

        public Work build() {
            return  new Work(this);
        }


    }


}