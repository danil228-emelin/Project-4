package item;

public class Essence {
    protected String itemName;

    public Essence(String name) {

        itemName = name;
        itemProblem = "there is no problem";
    }

    public Essence(String name, String itemProblem) {

        itemName = name;
        this.itemProblem = itemProblem;
    }


    protected String itemProblem;

    public String getItemProblem() {
        return itemProblem;
    }

    public String getItemName() {
        return itemName;
    }
}
