package creatures.behavior;


import java.util.ArrayList;
import creatures.Short;
import java.util.List;

public class Relationship {
    private Short creature;
    private List<Short> rivals = new ArrayList<>();
    private List<Short> friends = new ArrayList<>();

    public Relationship(Short c) {
        creature = c;
    }

    private void removeFriend(Short a) {
        if (friends.contains(a)) {
            friends.remove(a);
        }

    }

    private void removeRival(Short a) {
        if (rivals.contains(a)) {
            rivals.remove(a);
        }

    }

    public void addRivals(Short... a) {
        for (Short shortman : a) {
            if (rivals.contains(shortman)) {
                continue;
            }
            rivals.add(shortman);
            removeFriend(shortman);
        }
    }

    public void addFriends(Short... a) {
        for (Short shortman : a) {
            if (friends.contains(shortman)) {
                continue;
            }
            friends.add(shortman);
            removeRival(shortman);
        }
    }

    public void getRelationSheep(Short a) {
        if (rivals.contains(a)) {
            System.out.println(a.toString() + " - rival");
        } else if (friends.contains(a)) {

            System.out.println(a.toString() + " - friend");
        } else {
            System.out.println("We don't know each other");
        }
    }

    public void getAllFriends() {
        System.out.println("friends of - " + creature.toString() + " {");
        friends.forEach(System.out::println);
        System.out.println("}");
    }

    public void getAllRivals() {
        System.out.println("rivals of - " + creature.toString() + " {");

        rivals.forEach(System.out::println);
        System.out.println("}");
    }
}
