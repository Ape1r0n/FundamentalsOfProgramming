package AtTheZoo;

public class Animal {
    private String name;
    private int foodCosts;

    public Animal(String name, int foodCosts){
        this.name = name;
        this.foodCosts = foodCosts;
    }

    public String getName(){
        return name;
    }

    public int getFoodCosts(){
        return foodCosts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFoodCosts(int foodCosts) {
        this.foodCosts = foodCosts;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("(name: " + this.name + ", foodCosts: " + this.foodCosts + ")");
        return builder.toString();
    }
}