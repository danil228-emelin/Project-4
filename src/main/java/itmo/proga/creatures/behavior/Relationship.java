package itmo.proga.creatures.behavior;


import itmo.proga.creatures.Shorty;

import java.util.ArrayList;
import java.util.List;

public class Relationship {
    private final Shorty creature;

    private final List<Shorty> friends = new ArrayList<>();

    public Relationship(Shorty c) {
        creature = c;
    }





    public void addFriends(Shorty... a) {
        for (Shorty shortMan : a) {
            if (friends.contains(shortMan)) {
                continue;
            }
            friends.add(shortMan);
        }
    }


    public void getAllFriends() {
        System.out.println("friends of - " + creature.toString() + " {");
        friends.forEach(System.out::println);
        System.out.println("}");
    }


}
