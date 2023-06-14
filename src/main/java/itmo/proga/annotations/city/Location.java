package itmo.proga.annotations.city;

import java.lang.annotation.*;


@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(LocationContainer.class)
public @interface Location {
    String name();
    String city();
}

