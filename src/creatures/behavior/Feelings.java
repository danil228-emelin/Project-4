package creatures.behavior;

public enum Feelings {
    ANGRY("angry"), EXHAUSTED("exhausted"), RELAXED("relaxed");
    private String title;

    private Feelings(String s) {
        title = s;
    }

    public String getTitle() {
        return title;

    }
}

