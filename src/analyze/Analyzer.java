package analyze;

import annotations.CityAnnotation;
import creatures.Shorty;
import item.City;
import main.Main;

import java.util.Optional;

public class Analyzer {


    private static final Analyzer analyzer = new Analyzer();

    private Analyzer() {
    }


    public static Analyzer getAnalyzer() {
        return analyzer;
    }

    public void analyzeCity() {


        for (City city : City.cities) {
            CityAnnotation[] annotations = city.getClass().getAnnotationsByType(CityAnnotation.class);

            for (CityAnnotation annotation : annotations) {
                Shorty shorty = Main.shorts.get(annotation.name());
                Optional<Shorty> shortyOptional = Optional.ofNullable(shorty);
                shortyOptional.ifPresent(
                        x -> {
                            City c = x.getLocation();

                            if (c != city && c != null) {
                                c.setPopulation(c.getPopulation() - 1);
                            }


                            if (c == null || c != city) {
                                x.setLocation(city);
                                city.setPopulation(city.getPopulation() + 1);
                                System.out.println(shorty + " is in " + city);
                            }
                        }
                );
            }

        }

    }


}



