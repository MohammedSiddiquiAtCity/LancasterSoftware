package org.redsox.lancastersfx.core;

import java.util.Vector;

public class Kitchen {
    Vector<Order> orders = new Vector<>();
    Inventory inventory = new Inventory();

    public Kitchen() {

    }

    public void addStock(String name, int quantity){
        inventory.addStock(name, quantity);
    }

    public void removeStock(String name, int quantity){
        inventory.removeStock(name, quantity);
    }

    public void reviewRecipe(int recipeID){
        // get the recipe details.
        // get a response from the Chef to be added to the recipe.
    }

    public void approveRecipe(int recipeID){
        // get the recipe details.
        // get a response from the Chef to be added to the recipe.

    }

    public void postDish(Dish dish){

    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Vector<Order> getOrders() {
        return orders;
    }

    public void setOrders(Vector<Order> orders) {
        this.orders = orders;
    }
}
