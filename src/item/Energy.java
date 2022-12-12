package item;

public class Energy extends Essence {
    private String itemType;
    private int power;

    public Energy(int s, String problemDescription, String energyType) {
        super("Energy", problemDescription);
        itemType = energyType;
        power = s;
    }


}
