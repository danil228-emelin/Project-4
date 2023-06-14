package itmo.proga.item;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Factory extends Essence {
    public static final Map<String, Factory> factories = new HashMap<>();
    private final LinkedList<Blueprint> blueprints = new LinkedList<>();


    public Factory(String name) {
        super(name);
        setItemType("factory");
        factories.put(name, this);
    }

    public LinkedList<Blueprint> getBlueprints() {
        return blueprints;
    }

}
