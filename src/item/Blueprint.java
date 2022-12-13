package item;

import analyze.Analyzer;
import annotations.description.AnnotationDescription;
import annotations.blueprint.BluePrintMethod;

import java.util.HashMap;
import java.util.Map;

@AnnotationDescription(description = "production of individual castings")
@AnnotationDescription(description = "production of forgings")
@AnnotationDescription(description = "production of stampings for  equipment creation for controlling a spacecraft")
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
