package org.redsox.lancastersfx.core;

/**
 * The Ingredient class represents an ingredient used in a recipe.
 * It contains information about the ingredient's ID, name, and quantity.
 */
public class Ingredient {

    /** The unique identifier of the ingredient. */
    private int id;

    /** The name of the ingredient. */
    private String ingredientName;

    /** The quantity of the ingredient. */
    private int quantity;

    /**
     * Constructs an Ingredient object with default values.
     * This constructor initializes the ingredient with default values.
     */
    public Ingredient() {
        // Initialize with default values if needed
        this.id = 0; // Assuming 0 is the default value for an uninitialized id
        this.ingredientName = "";
        this.quantity = 0;
    }

    /**
     * Constructs an Ingredient object with the specified ID, name, and quantity.
     *
     * @param id the unique identifier of the ingredient
     * @param ingredientName the name of the ingredient
     * @param quantity the quantity of the ingredient
     */
    public Ingredient(int id, String ingredientName, int quantity) {
        this.id = id;
        this.ingredientName = ingredientName;
        this.quantity = quantity;
    }

    /**
     * Returns the name of the ingredient.
     *
     * @return the name of the ingredient
     */
    public String getIngredientName() {
        return ingredientName;
    }

    /**
     * Sets the name of the ingredient.
     *
     * @param ingredientName the new name of the ingredient
     */
    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    /**
     * Returns the quantity of the ingredient.
     *
     * @return the quantity of the ingredient
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the ingredient.
     *
     * @param quantity the new quantity of the ingredient
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns the ID of the ingredient.
     *
     * @return the ID of the ingredient
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the ingredient.
     *
     * @param id the new ID of the ingredient
     */
    public void setId(int id) {
        this.id = id;
    }
}
