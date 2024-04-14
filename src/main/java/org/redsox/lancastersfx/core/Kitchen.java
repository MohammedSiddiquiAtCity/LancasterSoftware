package org.redsox.lancastersfx.core;

import java.util.Vector;

public class Kitchen {
    Vector<Chef> chefs = new Vector<>();
    Vector<Recipe> recipes = new Vector<>();
    Vector<Menu> menus = new Vector<>();
    Vector<Order> orders = new Vector<>();
    Inventory inventory;

    public Kitchen(Inventory inventory) {
        this.inventory = inventory;
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

    public Vector<Chef> getChefs() {
        return chefs;
    }

    public void addChef(Chef chef) {
        this.chefs.add(chef);
    }

    public Vector<Recipe> getRecipes() {
        return recipes;
    }

    public void addRecipe(Recipe recipe) {
        this.recipes.add(recipe);
    }

    public Vector<Menu> getMenus() {
        return menus;
    }

    public void createMenu(Menu menu) {
        this.menus.add(menu);
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
