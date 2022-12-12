package creatures;

import creatures.behavior.Behavior;
import creatures.behavior.Feelings;
import creatures.behavior.Relationship;
import item.City;
import work.Job;

import java.util.LinkedList;

public class Shorty extends ShortIdentity implements Entity, Comparable<Shorty> {
    public static final LinkedList<Shorty> allShorts = new LinkedList<>();

    public void getLocation() {
        System.out.println(name+" is now in " + location);
    }

    private Job job;
    private City location;
    public static final Behavior Behave= new Behavior();
    private Shorty(String creatureName) {
        name = creatureName;
        int randomNumber = (int) ((Math.random() * 1000) + 1);
        magicPower = randomNumber % 999;
        iq = randomNumber % 100;
        strength = randomNumber % 10;
        uniqueness = iq + strength + magicPower;
        relationship = new Relationship(this);
        allShorts.add(this);
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

    public Shorty setLocation(City location) {
        this.location = location;
        return this;
    }
}
