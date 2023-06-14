package itmo.proga.work;

public enum WorkCondition {
    SlOW("com.example.work goes slowly", 0),
    FAST("com.example.work is exciting", 2),
    FINISH("com.example.work is done", 4),
    MIDDLE("routine business", 1);

    private String attitude;
    private int efficiency;

    WorkCondition(String s, int i) {
        attitude = s;
        efficiency = i;
    }

    public String getAttitude() {
        return attitude;
    }

    public int getEfficiency() {
        return efficiency;
    }
}