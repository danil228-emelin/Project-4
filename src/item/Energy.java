package item;

public class Energy extends Essence {

    private int power;

    public Energy(int s, String problemDescription, String energyType) {

      super("Energy");
        setItemDescription(problemDescription);
        setItemType(energyType);
        power = s;
    }


}
