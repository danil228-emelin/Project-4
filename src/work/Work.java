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

    public Work(String job, Short shorties) {

        workType = job;
        creature = shorties;
        workCondition = WorkCondition.MIDDLE;
        WorkAction.calculateWorkEfficiency(this);
    }


   public void  workActions(Consumer<Work> action) {
    action.accept(this);
   }



}



