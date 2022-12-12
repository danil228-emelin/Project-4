package creatures.behavior;


import java.util.ArrayList;
import creatures.Shorty;
import java.util.List;

public class Relationship {
    private Shorty creature;
    private List<Shorty> rivals = new ArrayList<>();
    private List<Shorty> friends = new ArrayList<>();

    public Relationship(Shorty c) {
        creature = c;
    }

    private void removeFriend(Shorty a) {
        if (friends.contains(a)) {
            friends.remove(a);
        }

    }

    private void removeRival(Shorty a) {
        if (rivals.contains(a)) {
            rivals.remove(a);
        }

    }

    public void addRivals(Shorty... a) {
        for (Shorty shortman : a) {
            if (rivals.contains(shortman)) {
                continue;
            }
            rivals.add(shortman);
            removeFriend(shortman);
        }
    }

    public void addFriends(Shorty... a) {
        for (Shorty shortman : a) {
            if (friends.contains(shortman)) {
                continue;
            }
            friends.add(shortman);
            removeRival(shortman);
        }
    }

    public void getRelationSheep(Shorty a) {
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
