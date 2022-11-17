package work;

import java.util.function.Consumer;
import creatures.Short;
public class Work {


    protected WorkCondition workCondition;
    protected int workEfficiency;
    protected String workType;
    protected Short creature;

    public enum WorkCondition {
        SlOW("работа идет медленнно,она не интересная"),
        FAST("Работа воодушевляет,она интересная"),
        MIDDLE("рутинное дело");

        private String attitude;

         WorkCondition(String s) {
            attitude = s;
        }

        public String getAttitude() {
            return attitude;
        }
    }

    private Work(WorkBuilder builder) {

        workType = builder.workType;
        creature = builder.creature;
        workCondition = WorkCondition.MIDDLE;
        WorkAction.calculateWorkEfficiency(this);
    }

public static class WorkBuilder{

    private String workType;
    private Short creature;

    public WorkBuilder setWorkType(String workType) {
        this.workType = workType;
        return this;
    }

    public WorkBuilder setCreature(Short creature) {
        this.creature = creature;
        return this;
    }
public Work build(){
  return new Work(this);
}


    }




   public void  workActions(Consumer<Work> action) {
    action.accept(this);
   }

}



