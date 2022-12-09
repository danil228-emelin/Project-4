package creatures.behavior;

import creatures.Short;

import java.util.function.Consumer;

public class BehaveMediator implements MediatorBehaviour {


@Override
    public void action(Consumer<Short> l, Short creature) {
        l.accept(creature);

    }
@Override
    public void actionRelationShip(Consumer<Relationship> l, Short creature) {
        l.accept(creature.getRelationship());
    }


}
