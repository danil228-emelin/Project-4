package annotations;

import annotations.CityAnnotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME)
public @interface ContainerCity {
    CityAnnotation[] value();
}