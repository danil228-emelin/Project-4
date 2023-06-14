package itmo.proga.item;

import itmo.proga.annotations.city.Location;
import itmo.proga.creatures.Shorty;
import itmo.proga.item.creature_exception.NotFoundCreatureException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@Location(name = "Fuchsia", city = "ScienceCity")
@Location(name = "Herring", city = "ScienceCity")
@Location(name = "Constructor1", city = "ScienceCity")
@Location(name = "Constructor2", city = "ScienceCity")
@Location(name = "Constructor3", city = "ScienceCity")
@Location(name = "Klepka", city = "SunCity")
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

    public static City getLocation(Shorty shorty) throws NotFoundCreatureException {

        if (shorty == null) {
            throw new NotFoundCreatureException();
        }
        return shorty.getLocation();
    }

    public static City getLocation(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)))) {

            String creatureName = bufferedReader.readLine();
            Shorty shorty = Shorty.shorts.get(creatureName);
            if (shorty == null) {
                throw new NotFoundCreatureException();
            }
            return shorty.getLocation();
        } catch (Exception exception) {
            exception.printStackTrace();
            Throwable[] throwables = exception.getSuppressed();
            for (Throwable throwable : throwables) {
                throwable.getLocalizedMessage();
                throwable.printStackTrace();
            }

        }
        return null;
    }


}
