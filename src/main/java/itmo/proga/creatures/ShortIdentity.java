package itmo.proga.creatures;

import itmo.proga.creatures.behavior.Feelings;
import itmo.proga.creatures.behavior.Relationship;


abstract public class ShortIdentity  implements Entity, Comparable<Shorty>{

    protected Relationship relationship;
    protected Feelings emotions;

    protected String name;
    protected int iq;
    protected int strength;
    protected int magicPower;
    protected int uniqueness;


}
