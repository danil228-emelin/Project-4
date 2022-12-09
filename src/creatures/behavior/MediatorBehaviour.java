package creatures.behavior;

import creatures.Short;

import java.util.function.Consumer;

public interface MediatorBehaviour {
     void action(Consumer<Short> l,Short creature);
    void actionRelationShip(Consumer<Relationship> l,Short creature);


}
