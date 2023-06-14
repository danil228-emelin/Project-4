package itmo.proga.creatures.behavior;

public enum Feelings {
    ANGRY("angry"),HAPPY("happy");
    private final String title;

    Feelings(String s) {
        title = s;
    }

    public String getTitle() {
        return title;

    }
}

