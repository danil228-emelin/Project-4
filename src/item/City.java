package item;

import annotations.city.CityAnnotation;
import creatures.Shorty;

import java.util.HashMap;
import java.util.LinkedList;
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
    private final LinkedList<Shorty> citizens = new LinkedList<>();

    public LinkedList<Shorty> getCitizens() {
        return citizens;
    }

    public City(String name) {
        this.name = name;
        allCities.put(name, this);
    }


    @Override
    public String toString() {
        return name;
    }


}
