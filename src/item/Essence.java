package item;

public class Essence {
    protected String itemName;
    protected String itemType;
    protected String itemProblem;

    public String getItemProblem() {
        return itemProblem;
    }


    public String getItemName() {
        return itemName;
    }

    public Essence(String name, String problem, String type) {
        itemProblem = problem;
        itemName = name;
        itemType = type;
    }

    public Essence(String name) {
        itemProblem = "there is no problem";
        itemName = name;
        itemType = "there is no type";
    }



}
