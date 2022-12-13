package annotations.description;

import java.lang.annotation.*;

@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(DescriptionContainer.class)
public @interface AnnotationDescription {
String description();
}
