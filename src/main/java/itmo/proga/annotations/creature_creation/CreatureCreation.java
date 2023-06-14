package itmo.proga.annotations.creature_creation;


import java.lang.annotation.*;

@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(CreatureCreationContainer.class)
public @interface CreatureCreation {
    String creatureName();
}
