package itmo.proga.item;

import itmo.proga.analyze.Analyzer;
import itmo.proga.annotations.blueprint.BluePrintMethod;
import itmo.proga.annotations.description.ClassDescription;

import java.util.HashMap;
import java.util.Map;

@ClassDescription(description = "production of individual castings")
@ClassDescription(description = "production of forgings")
@ClassDescription(description = "production of stampings for  equipment creation for controlling a spacecraft")
public class Blueprint extends Essence {

    public Blueprint(String name) {
        super(name);
        setItemDescription("");
        setItemType("blueprint");
        blueprints.put(name, this);
    }

    public static final Map<String, Blueprint> blueprints = new HashMap<>();

    public void getDescription() {
        System.out.println(this + " is for " + getItemDescription());
    }

    @BluePrintMethod(factoryName = "factory1", BluePrintName = "Blueprints")
    @BluePrintMethod(factoryName = "factory2", BluePrintName = "Blueprints")
    public static void send() {
        Analyzer.getAnalyzer().analyzeBluePrintMethod();

    }


}
