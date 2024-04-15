package org.redsox.lancastersfx.core;

public class Ingredient {
    // Class variables
    private int id;
    private String ingredientName;
    private int quantity;

    // No-argument constructor
    public Ingredient() {
        // Initialize with default values if needed
        this.id = 0; // Assuming 0 is the default value for an uninitialized id
        this.ingredientName = "";
        this.quantity = 0;
    }

    // Parameterized constructor
    public Ingredient(int id, String ingredientName, int quantity) {
        this.id = id;
        this.ingredientName = ingredientName;
        this.quantity = quantity;
    }

    // Getter and setter for ingredient name
    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    // Getter and setter for quantity
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Getter and setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}