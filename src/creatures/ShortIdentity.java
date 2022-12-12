package creatures;

import creatures.behavior.Feelings;
import creatures.behavior.Relationship;

import java.util.LinkedList;


abstract public class ShortIdentity {


    public int getUniqueness() {
        return uniqueness;
    }

    protected Relationship relationship;

    protected Feelings emotions;

    public Relationship getRelationship() {
        return relationship;
    }



    protected String name;
    protected int iq;
    protected int strength;
    protected int magicPower;
    protected int uniqueness;

    public Feelings getEmotions() {
        return emotions;
    }

    public String getName() {
        return name;
    }

    public int getIq() {
        return iq;
    }

    public int getStrength() {
        return strength;
    }

    public int getMagicPower() {
        return magicPower;
    }
}
