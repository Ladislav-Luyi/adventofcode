package org.example;

public class Ingredient {
    // Sugar: capacity 3, durability 0, flavor 0, texture -3, calories 2
    int capacity, durability, flavor, texture, calories;
    String name;
    public Ingredient(String name, int capacity, int durability, int flavor, int texture, int calories) {
        this.name = name;
        this.capacity = capacity;
        this.durability = durability;
        this.flavor = flavor;
        this.texture = texture;
        this.calories = calories;
    }


    public String getName() {
        return name;
    }
    public int getCapacity() {
        return capacity;
    }

    public int getDurability() {
        return durability;
    }

    public int getFlavor() {
        return flavor;
    }

    public int getTexture() {
        return texture;
    }

    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
               "capacity=" + capacity +
               ", durability=" + durability +
               ", flavor=" + flavor +
               ", texture=" + texture +
               ", calories=" + calories +
               ", name='" + name + '\'' +
               '}';
    }

}
