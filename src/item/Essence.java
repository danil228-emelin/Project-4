package item;


public class Essence {
    private String location ;

    public String getLocation() {
        return (this +" is in "+location);
    }

    public Essence setLocation(String location) {
        this.location = location;
        return this;
    }

    private final String itemName;

    public Essence(String name) {
     itemName = name;
    }

    private String itemType="";
    private String itemDescription="";

    public Essence setItemType(String itemType) {
        this.itemType = itemType;
        return this;
    }



    public Essence setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
        return this;
    }

    public String getItemType() {
        return itemType;
    }

    public String getItemDescription() {
        return itemDescription;
    }




    @Override

    public String toString() {
        return itemName;
    }
}
