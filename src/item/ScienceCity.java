package item;

import annotations.CityAnnotation;


@CityAnnotation(name = "Fuchsia")
@CityAnnotation(name = "Herring")
@CityAnnotation(name = "Constructor1")
@CityAnnotation(name = "Constructor2")
@CityAnnotation(name = "Constructor3")
public class ScienceCity extends City {


    public ScienceCity() {
        setName("ScienceCity");
        City.cities.add(this);
    }
}
