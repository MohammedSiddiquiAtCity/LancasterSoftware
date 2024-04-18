package org.redsox.lancastersfx.core;

/**
 * The Chef class represents a chef in a restaurant.
 * Each chef has an id, a name, and works in a specific kitchen.
 */
public class Chef {

    /** The unique identifier of the chef. */
    private int id;

    /** The name of the chef. */
    private String name;

    /** The kitchen where the chef works. */
    private Kitchen kitchen;

    /**
     * Constructs a Chef object with the specified id, name, and kitchen.
     *
     * @param id the unique identifier of the chef
     * @param name the name of the chef
     * @param kitchen the kitchen where the chef works
     */
    public Chef(int id, String name, Kitchen kitchen) {
        this.id = id;
        this.name = name;
        this.kitchen = kitchen;
    }

    /**
     * Adds the specified quantity of an ingredient to the kitchen's stock.
     *
     * @param name the name of the ingredient
     * @param quantity the quantity of the ingredient to add
     */
    public void addIngredient(String name, int quantity){
        kitchen.addStock(name, quantity);
    }

    /**
     * Removes the specified quantity of an ingredient from the kitchen's stock.
     *
     * @param name the name of the ingredient
     * @param quantity the quantity of the ingredient to remove
     */
    public void removeIngredient(String name, int quantity){
        kitchen.removeStock(name, quantity);
    }

    /**
     * Returns the id of the chef.
     *
     * @return the id of the chef
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id of the chef.
     *
     * @param id the new id of the chef
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the name of the chef.
     *
     * @return the name of the chef
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the chef.
     *
     * @param name the new name of the chef
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the kitchen where the chef works.
     *
     * @return the kitchen where the chef works
     */
    public Kitchen getKitchen() {
        return kitchen;
    }

    /**
     * Sets the kitchen where the chef works.
     *
     * @param kitchen the new kitchen where the chef works
     */
    public void setKitchen(Kitchen kitchen) {
        this.kitchen = kitchen;
    }
}
