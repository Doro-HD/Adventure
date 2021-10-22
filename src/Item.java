public class Item {
    private String type;
    private String name;
    private String description;

    public Item(String type, String name, String description) {
        this.setType(type);
        this.setName(name);
        this.setDescription(description);
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public String toString() {
        return "This is a " + this.type + "\n" + "It goes by the name: " + this.name + "\n" + "and it looks like this: " + this.description;
    }

}
