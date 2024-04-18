package org.redsox.lancastersfx.core;

import java.util.Vector;

/**
 * The Inventory class represents the inventory of ingredients in the kitchen.
 * It manages the stock of ingredients and provides methods for adding, removing, and updating them.
 */
public class Inventory {

    /** The vector containing the ingredients in the inventory. */
    private Vector<Ingredient> ingredients = new Vector<>();

    /**
     * Constructs an Inventory object.
     * This constructor initializes the inventory.
     */
    public Inventory() {
        // TODO: Implement initialization if needed
    }

    /**
     * Adds the specified quantity of an item to the stock.
     *
     * @param itemName the name of the item to add
     * @param quantity the quantity of the item to add
     */
    public void addStock(String itemName, int quantity) {
        // Use the DB connection to update the value in the DB
        // TODO: Implement logic to update stock in the database
    }

    /**
     * Removes the specified quantity of an item from the stock.
     *
     * @param itemName the name of the item to remove
     * @param quantity the quantity of the item to remove
     */
    public void removeStock(String itemName, int quantity){
        // Use the DB connection to update the value in the DB
        // TODO: Implement logic to update stock in the database
    }

    /**
     * Adds a new ingredient to the inventory.
     *
     * @param itemName the name of the ingredient to add
     */
    public void addIngredient(String itemName){
        // Use the DB connection to add the ingredient in the DB
        // TODO: Implement logic to add ingredient to the database
    }

    /**
     * Removes an ingredient from the inventory.
     *
     * @param itemName the name of the ingredient to remove
     */
    public void removeIngredient(String itemName){
        // Use the DB connection to remove the ingredient from the DB
        // TODO: Implement logic to remove ingredient from the database
    }

}
