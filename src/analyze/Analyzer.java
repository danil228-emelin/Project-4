package analyze;

import annotations.blueprint.BluePrintMethod;
import annotations.city.CityAnnotation;
import annotations.description.AnnotationDescription;
import annotations.description_method.MethodDescription;
import creatures.Shorty;
import item.Blueprint;
import item.Car;
import item.Essence;
import item.Factory;
import item.city.City;
import main.Main;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public class Analyzer {


    private static final Analyzer analyzer = new Analyzer();

    private Analyzer() {
    }


    public static Analyzer getAnalyzer() {
        return analyzer;
    }

    public void analyzeCity() {


        CityAnnotation[] annotations = City.class.getAnnotationsByType(CityAnnotation.class);

        for (CityAnnotation annotation : annotations) {
            Optional<City> city = Optional.ofNullable(City.allCities.get(annotation.city()));
            Optional<Shorty> shortyOptional = Optional.ofNullable(Main.shorts.get(annotation.name()));
            shortyOptional.ifPresent(
                    x -> {
                        City c = x.getLocation();

                        if (c != city.get() && c != null) {
                            c.setPopulation(c.getPopulation() - 1);
                        }


                        if (c == null || c != city.get()) {
                            city.ifPresent(l -> {
                                x.setLocation(l);
                                l.setPopulation(l.getPopulation() + 1);
                                System.out.println(shortyOptional.get() + " is in " + city.get());
                            });

                        }
                    }
            );
        }


    }


    public Essence analyzeBluePrint() {

        AnnotationDescription[] annotations = Blueprint.class.getAnnotationsByType(AnnotationDescription.class);
        String description = Arrays.stream(annotations).map(AnnotationDescription::description).collect(Collectors.joining(","));
        return new Blueprint("Blueprints").setItemDescription(description);
    }

    public void analyzeBluePrintMethod() {
        try {


            BluePrintMethod[] annotations = Blueprint.class.getMethod("send").getAnnotationsByType(BluePrintMethod.class);
            for (BluePrintMethod annotation : annotations) {
                Optional<Factory> optionalFactory = Optional.ofNullable(Factory.factories.get(annotation.factoryName()));
                optionalFactory.ifPresent(x -> {
                    Optional<Blueprint> optionalBlueprint = Optional.ofNullable(Blueprint.blueprints.get(annotation.BluePrintName()));
                    optionalBlueprint.ifPresent(a -> {
                        x.getBlueprints().add(a);
                        System.out.println(a + " is sent to  " + x);
                    });

                });
            }
        } catch (NoSuchMethodException error) {
            error.printStackTrace();
        }
    }

    public String analyzeMethodDescription(String methodName, Class<?> certainClass, Class<?>... args) {
        try {

            MethodDescription[] annotations = certainClass.getMethod(methodName, args).getAnnotationsByType(MethodDescription.class);
            return Arrays.stream(annotations).map(MethodDescription::item).collect(Collectors.joining(","));

        } catch (NoSuchMethodException error) {
            error.printStackTrace();
        }
        return "";
    }

    public Car analyzeCarDescription(Shorty shorty, String name) {

        AnnotationDescription[] annotations = Car.class.getAnnotationsByType(AnnotationDescription.class);
        String description = Arrays.stream(annotations).map(AnnotationDescription::description).collect(Collectors.joining(","));

        return (Car) new Car(name).setOwner(shorty).setItemDescription(description);
    }

}



