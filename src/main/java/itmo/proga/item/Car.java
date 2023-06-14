package itmo.proga.item;

import itmo.proga.annotations.description.ClassDescription;
import itmo.proga.creatures.Shorty;

@ClassDescription(description = "fast")
@ClassDescription(description = "diving")
@ClassDescription(description = "jumping")
@ClassDescription(description = "floating")
@ClassDescription(description = " flying")
public class Car extends Essence {
    private Shorty owner;

    public Car(String name) {
        super(name);


    }

    public Car setOwner(Shorty owner) {
        this.owner = owner;
        return this;
    }

    public void getDescription() {
    System.out.println(owner+" is driving on his " +getItemDescription()+" "+this+" in "+owner.getLocation());
    }
}
