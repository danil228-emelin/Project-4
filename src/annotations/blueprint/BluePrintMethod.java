package annotations.blueprint;

import java.lang.annotation.*;

@Target(value = ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(BlueContainerMethod.class)
public @interface BluePrintMethod {
    String factoryName();

    String BluePrintName();
}
