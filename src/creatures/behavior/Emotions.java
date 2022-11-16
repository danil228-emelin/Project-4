
package creatures.behavior;

import creatures.Short;
import work.Job;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Emotions {

    static private Map<Feeling, ArrayList<Short>> emotion = new HashMap<>();

    static {
        emotion.put(Feeling.ANGRY, new ArrayList<>());
        emotion.put(Feeling.EXHAUSTED, new ArrayList<>());
        emotion.put(Feeling.FLEXMODE, new ArrayList<>());
    }

    public enum Feeling {
        ANGRY("Злой"), EXHAUSTED("Уставший"), FLEXMODE("ЧИЛИТ");
        private String title;

        private Feeling(String s) {
            title = s;
        }

        private String getTitle() {
            return title;
        }
    }

    public static void describeEmotion(Short o) {
        Set<Feeling> key = emotion.keySet();
        for (Feeling k : key) {
            if (emotion.get(k).contains(o)) {
                System.out.println(o.toString() + " " + k.getTitle());
                return;
            }

        }
    }


    private static void changeEmotion(Short o) {
        Set<Feeling> key = emotion.keySet();
        for (Feeling k : key) {
            if (emotion.get(k).contains(o)) {
                emotion.get(k).remove(o);
                return;
            }

        }

    }

    public static void setEmotion(Short o, Feeling feel) {
        changeEmotion(o);
        emotion.get(feel).add(o);
    }


}
