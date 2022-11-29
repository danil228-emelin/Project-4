package work;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import creatures.Short;

public class Job {
    public enum CreatureType {CLEVEREST, WORKER, SCIENTIST}

    static private final Map<CreatureType, ArrayList<Short>> job = new HashMap<>();

    static {
        job.put(CreatureType.WORKER, new ArrayList<>());
        job.put(CreatureType.CLEVEREST, new ArrayList<>());
        job.put(CreatureType.SCIENTIST, new ArrayList<>());
    }

    public static void startWork(Short o, CreatureType type) {
        ArrayList<Short> v = job.get(type);
        if (!v.contains(o)) {
            v.add(o);
        }
    }





}
