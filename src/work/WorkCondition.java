package work;

public enum WorkCondition {
    SlOW("work goes slowly"),
    FAST("work is exciting"),
    MIDDLE("routine business");

    private String attitude;

    WorkCondition(String s) {
        attitude = s;
    }

    public String getAttitude() {
        return attitude;
    }
}