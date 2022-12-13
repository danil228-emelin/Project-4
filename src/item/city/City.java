package item.city;

import annotations.city.CityAnnotation;

import java.util.HashMap;
import java.util.Map;

@CityAnnotation(name = "Fuchsia", city = "ScienceCity")
@CityAnnotation(name = "Herring", city = "ScienceCity")
@CityAnnotation(name = "Constructor1", city = "ScienceCity")
@CityAnnotation(name = "Constructor2", city = "ScienceCity")
@CityAnnotation(name = "Constructor3", city = "ScienceCity")
@CityAnnotation(name = "Klepka", city = "SunCity")
public class City {
    private final String name;
    public static final Map<String, City> allCities = new HashMap<>();


    public City(String name) {
        this.name = name;
        allCities.put(name, this);
    }


    private int population;

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;

    }

    @Override
    public String toString() {
        return name;
    }


}
