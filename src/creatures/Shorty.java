package creatures;

import creatures.behavior.Behavior;
import creatures.behavior.Feelings;
import creatures.behavior.Relationship;
import item.city.City;
import work.Job;
import main.Main;
import java.util.LinkedList;

public class Shorty extends ShortIdentity implements Entity, Comparable<Shorty> {
    public static final LinkedList<Shorty> allShorts = new LinkedList<>();

    public City getLocation() {
        return location;
    }

    private Job job;
    private City location = null;
    public static final Behavior Behave = Behavior.getBehavior();

    private Shorty(String creatureName) {
        name = creatureName;
        int randomNumber = (int) ((Math.random() * 1000) + 1);
        magicPower = randomNumber % 999;
        iq = randomNumber % 100;
        strength = randomNumber % 10;
        uniqueness = iq + strength + magicPower;
        relationship = new Relationship(this);
        allShorts.add(this);
        Main.shorts.put(name,this);
    }

    public static Shorty createShort(String creatureName) {
        return new Shorty(creatureName);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Shorty o) {
        return uniqueness - o.getUniqueness();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Shorty) {
            Shorty other = (Shorty) obj;
            return other.uniqueness == uniqueness;
        } else return false;
    }

    @Override
    public int hashCode() {
        return uniqueness;
    }


    public void describeEmotion() {
        System.out.println(name + " is " + emotions.getTitle());
    }

    public void setEmotions(Feelings f) {
        emotions = f;
    }

    public void setJob(Job job) {
        this.job = job;

    }

    public Job getJob() {
        return job;
    }

    public void setLocation(City location) {
        this.location = location;

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
    public Relationship getRelationship() {
        return relationship;
    }
    public int getUniqueness() {
        return uniqueness;
    }
}
