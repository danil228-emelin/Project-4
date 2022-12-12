package creatures.behavior;

import creatures.Short;

import java.util.function.Consumer;

public interface Behave {
    void action (Consumer<Short> move, Short shorty);

    void actionRelationSheep (Consumer<Relationship> move,Short shorty);

}
