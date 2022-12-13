package annotations.city;

import java.lang.annotation.*;


@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(ContainerCity.class)
public @interface CityAnnotation {
    String name();
    String city();
}

