package annotations.blueprint;

import annotations.blueprint.BlueContainerMethod;

import java.lang.annotation.*;

@Target(value = ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(BlueContainerMethod.class)
public @interface BluePrintMethod {
String factoryName();
String BluePrintName();
}
