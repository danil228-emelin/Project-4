package creatures.behavior;

import creatures.Shorty;

import java.util.function.Consumer;

public interface Behave {
    void action (Consumer<Shorty> move, Shorty shorty);

    void actionRelationSheep (Consumer<Relationship> move, Shorty shorty);

}
