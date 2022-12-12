package annotations;

import creatures.Shorty;

import java.lang.annotation.*;


@Repeatable(ContainerCity.class)
@Retention(RetentionPolicy.RUNTIME)

 public @interface CityAnnotation {
    String name();
}

