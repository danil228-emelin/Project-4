package itmo.proga.annotations.description;

import java.lang.annotation.*;

@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(ClassDescriptionContainer.class)
public @interface ClassDescription {
String description();
}
