import annotations.CityAnnotation;
import creatures.Shorty;
import item.City;

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
                shorty.setLocation(city);
                city.setPopulation(city.getPopulation()+1);
            }

        }


    }


}
