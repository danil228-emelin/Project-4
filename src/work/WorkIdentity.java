package work;

import creatures.Short;


public class WorkIdentity {


    protected WorkCondition workCondition;
    protected int workEfficiency;
    protected String workType;
    protected Short creature;

    private  WorkIdentity(WorkBuilder w){
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

        public ProxyWorkIdentity build() {
            return new ProxyWorkIdentity(new WorkIdentity(this));
        }


    }


}



