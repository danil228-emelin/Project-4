package creatures;

import creatures.behavior.BehaveMediator;
import creatures.behavior.Feelings;
import creatures.behavior.Relationship;
import work.Job;

import java.util.function.Consumer;

public class Short extends ShortIdentity implements Entity, Comparable<Short> {
    private Job job;
    public static final BehaveMediator  behaveMediator= new BehaveMediator();
    private Short(String creatureName) {
        name = creatureName;
        int randomNumber = (int) ((Math.random() * 1000) + 1);
        magicPower = randomNumber % 999;
        iq = randomNumber % 100;
        strength = randomNumber % 10;
        uniqueness = iq + strength + magicPower;
        relationship = new Relationship(this);

    }

    public static Short createShort(String creatureName) {
        return new Short(creatureName);
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



    public void describeEmotion() {
        System.out.println(name + " is " + emotions.getTitle());
    }

    public void setEmotions(Feelings f) {
        emotions = f;
    }

    public void setJob(Job job) {
        this.job = job;

    }
}
