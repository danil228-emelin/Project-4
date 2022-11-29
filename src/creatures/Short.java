package creatures;

import creatures.behavior.Relationship;

import java.util.function.Consumer;

public class Short extends ShortIdentity implements Entity, Comparable<Short> {
    private final Relationship relationship;

    public Short(String creatureName) {
        name = creatureName;
        int randomNumber = (int) ((Math.random() * 1000) + 1);
        magicPower = randomNumber % 999;
        iq = randomNumber % 100;
        strength = randomNumber % 10;
        uniqueness = iq + strength + magicPower;
        relationship = new Relationship(this);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Short o) {
        return uniqueness - o.getUniqueness();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Short) {
            Short other = (Short) obj;
            return other.uniqueness == uniqueness;
        } else return false;
    }

    @Override
    public int hashCode() {
        return uniqueness;
    }

    public int getStrength() {
        return strength;
    }

    public int getMagicPower() {
        return magicPower;
    }

    public int getIq() {
        return iq;
    }

    public int getUniqueness() {
        return uniqueness;
    }

    public void action(Consumer<Short> l) {
        l.accept(this);
    }

    public void actionRelationShip(Consumer<Relationship> l) {
        l.accept(relationship);
    }


}
