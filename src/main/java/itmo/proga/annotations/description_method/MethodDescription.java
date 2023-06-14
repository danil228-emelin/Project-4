package itmo.proga.annotations.description_method;


import java.lang.annotation.*;

@Target(value = ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MethodDescriptionContainer.class)
public @interface MethodDescription {
    String item();

}
