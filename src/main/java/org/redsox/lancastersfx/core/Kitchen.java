package org.redsox.lancastersfx.core;

import java.util.Vector;

/**
 * The Kitchen class represents the kitchen of a restaurant.
 * It manages orders, inventory, and recipe-related operations.
 */
public class Kitchen {

    /** The vector containing the orders in the kitchen. */
    Vector<Order> orders = new Vector<>();

    /** The inventory of ingredients in the kitchen. */
    Inventory inventory = new Inventory();

    /**
     * Constructs a Kitchen object.
     * This constructor initializes the kitchen.
     */
    public Kitchen() {
        // TODO: Implement initialization if needed
    }

    /**
     * Adds the specified quantity of an item to the inventory stock.
     *
     * @param name the name of the item to add
     * @param quantity the quantity of the item to add
     */
    public void addStock(String name, int quantity){
        inventory.addStock(name, quantity);
    }

    /**
     * Removes the specified quantity of an item from the inventory stock.
     *
     * @param name the name of the item to remove
     * @param quantity the quantity of the item to remove
     */
    public void removeStock(String name, int quantity){
        inventory.removeStock(name, quantity);
    }

    /**
     * Reviews a recipe with the specified ID.
     * This method retrieves the recipe details and gets a response from the chef.
     *
     * @param recipeID the ID of the recipe to review
     */
    public void reviewRecipe(int recipeID){
        // Get the recipe details
        // Get a response from the Chef to be added to the recipe
    }

    /**
     * Approves a recipe with the specified ID.
     * This method retrieves the recipe details and gets a response from the chef.
     *
     * @param recipeID the ID of the recipe to approve
     */
    public void approveRecipe(int recipeID){
        // Get the recipe details
        // Get a response from the Chef to be added to the recipe
    }

    /**
     * Posts a dish to the kitchen.
     *
     * @param dish the dish to be posted
     */
    public void postDish(Dish dish){
        // Implementation to post the dish will be added later
    }

    /**
     * Returns the inventory of the kitchen.
     *
     * @return the inventory of the kitchen
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Sets the inventory of the kitchen.
     *
     * @param inventory the new inventory of the kitchen
     */
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    /**
     * Returns the orders in the kitchen.
     *
     * @return the orders in the kitchen
     */
    public Vector<Order> getOrders() {
        return orders;
    }

    /**
     * Sets the orders in the kitchen.
     *
     * @param orders the new orders in the kitchen
     */
    public void setOrders(Vector<Order> orders) {
        this.orders = orders;
    }
}
