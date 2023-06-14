package itmo.proga.analyze;

import itmo.proga.annotations.blueprint.BluePrintMethod;
import itmo.proga.annotations.city.Location;
import itmo.proga.annotations.creature_interaction.CreaturesInteraction;
import itmo.proga.annotations.description.ClassDescription;
import itmo.proga.annotations.description_method.MethodDescription;
import itmo.proga.creatures.Shorty;
import itmo.proga.creatures.behavior.CreatureInteraction;
import itmo.proga.annotations.creature_creation.CreatureCreation;
import itmo.proga.item.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
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


        Location[] annotations = City.class.getAnnotationsByType(Location.class);

        for (Location annotation : annotations) {
            Optional<City> city = Optional.ofNullable(City.allCities.get(annotation.city()));
            Optional<Shorty> shortyOptional = Optional.ofNullable(Shorty.shorts.get(annotation.name()));
            shortyOptional.ifPresent(
                    x -> {
                        City c = x.getLocation();
                        if (city.isPresent() && city.get() != c && c != null) {
                            c.getCitizens().remove(x);
                        }

                        if (c == null || c != city.get()) {
                            city.ifPresent(l -> {
                                x.setLocation(l);
                                l.getCitizens().add(x);
                                System.out.println(shortyOptional.get() + " is in " + city.get());
                            });

                        }
                    }
            );
        }
    }


    public Essence analyzeBluePrint() {

        ClassDescription[] annotations = Blueprint.class.getAnnotationsByType(ClassDescription.class);
        String description = Arrays.stream(annotations).map(ClassDescription::description).collect(Collectors.joining(","));
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

        ClassDescription[] annotations = Car.class.getAnnotationsByType(ClassDescription.class);
        String description = Arrays.stream(annotations).map(ClassDescription::description).collect(Collectors.joining(","));

        return (Car) new Car(name).setOwner(shorty).setItemDescription(description);
    }


    public void analyzeCreatureCreation() {

        CreatureCreation[] annotations = Shorty.class.getAnnotationsByType(CreatureCreation.class);
        Arrays.stream(annotations).filter(x ->
                        Objects.isNull(Shorty.shorts.get(x.creatureName()))).
                forEach(x ->
                        Shorty.shorts.put(x.creatureName(), Shorty.createShort(x.creatureName())));

    }


    public void analyzeCreatureInteraction(String methodName) {

        try {

            Method method = CreatureInteraction.class.getMethod(methodName, Shorty.class, Shorty.class);
            CreaturesInteraction[] annotations = method.getAnnotationsByType(CreaturesInteraction.class);

            for (CreaturesInteraction annotation : annotations) {
                Optional<Shorty> firstShorty = Optional.ofNullable(Shorty.shorts.get(annotation.firstCreature()));
                Optional<Shorty> secondShorty = Optional.ofNullable(Shorty.shorts.get(annotation.secondCreature()));

                if (firstShorty.isPresent() && secondShorty.isPresent()) {
                    method.invoke(null, firstShorty.get(), secondShorty.get());
                }
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException exception) {
            System.out.println(exception);
            exception.printStackTrace();
        }


    }
}


