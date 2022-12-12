package item;

import java.util.LinkedList;

abstract public class City {
    protected String name;

    public String getName() {
        return name;
    }

    public static final LinkedList<City> cities = new LinkedList<>();


    public City setName(String name) {
        this.name = name;
        return this;
    }

    private int population;

    public int getPopulation() {
        return population;
    }

    public City setPopulation(int population) {
        this.population = population;
        return this;
    }

    @Override
    public String toString() {
        return name;
    }



}
