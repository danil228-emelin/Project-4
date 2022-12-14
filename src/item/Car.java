package item;

import annotations.description.AnnotationDescription;
import creatures.Shorty;

@AnnotationDescription(description = "fast")
@AnnotationDescription(description = "diving")
@AnnotationDescription(description = "jumping")
@AnnotationDescription(description = "floating")
@AnnotationDescription(description = " flying")
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
