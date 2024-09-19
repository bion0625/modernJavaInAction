package streamUsing;

public class Dish {
    public Dish() {}
    public Dish(String name, boolean vegetarian, int calories, Dish.Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }
    private String name;
    private boolean vegetarian;
    private int calories;
    private Dish.Type type;

    public String getName() {
        return this.name;
    }

    public boolean isVegetarian() {
        return this.vegetarian;
    }

    public int getCalories() {
        return this.calories;
    }

    public Dish.Type getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return name;
    }

    public enum Type { MEAT,OTHER,FISH }
}
