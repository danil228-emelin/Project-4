package item;

public class Energy extends Essence {

    private int power;

    public Energy(int s, String problemDescription, String energyType) {
        super("Энергия", problemDescription, energyType);
        power = s;
    }


    public void action(Energy other) {

        if (itemType == itemType) {
            System.out.printf("Energy power is %d\n", power + other.power);
        } else {
            System.out.println("unknown result");
        }
    }

}
