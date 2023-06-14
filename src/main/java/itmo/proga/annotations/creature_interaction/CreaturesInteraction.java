package itmo.proga.annotations.creature_interaction;

import java.lang.annotation.*;

@Target(value = ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(CreatureInteractionContainer.class)
public @interface CreaturesInteraction {
    String firstCreature();

    String secondCreature();

}
