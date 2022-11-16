package work;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import creatures.Short;
public class Job {
    public enum CreatureType {CLEVEREST, СONSTRUCTORS, SCIENTIST}

static private Map<CreatureType, ArrayList<Short>> job = new HashMap<>();

    static {
        job.put(CreatureType.СONSTRUCTORS,new ArrayList<>());
        job.put(CreatureType.CLEVEREST,new ArrayList<>());
        job.put(CreatureType.SCIENTIST,new ArrayList<>());
    }

    public static void startWork(Short o, CreatureType type) {
        ArrayList<Short> v = job.get(type);
        if (!v.contains(o)) {
            v.add(o);
        }
    }

    public static void whomIWork(Short o) {
        Set<CreatureType> key = job.keySet();
        for (CreatureType k : key) {
            if (job.get(k).contains(o)) {
                System.out.println(o.toString() + " work as " + k.toString());
            }

        }
    }

    public static void stopWork(Short o, CreatureType type) {
        ArrayList<Short> v = job.get(type);
        if (v.contains(o)) {
            v.remove(o);
        }
    }






}
