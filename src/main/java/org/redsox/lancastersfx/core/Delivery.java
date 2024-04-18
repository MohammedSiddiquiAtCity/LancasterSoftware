package org.redsox.lancastersfx.core;

/**
 * The Delivery class represents a delivery of ingredients to a kitchen.
 * Each delivery is associated with a specific kitchen and date.
 */
public class Delivery {

    /** The kitchen to which the delivery is made. */
    private Kitchen kitchen;

    /** The date of the delivery. */
    private int date;

    /**
     * Constructs a Delivery object with the specified kitchen and date.
     *
     * @param kitchen the kitchen to which the delivery is made
     * @param date the date of the delivery
     */
    public Delivery(Kitchen kitchen, int date) {
        this.kitchen = kitchen;
        this.date = date;
    }

    /**
     * Adds ingredients to the kitchen during the delivery.
     * This method is intended to be implemented to add ingredients
     * to the kitchen's stock during a delivery.
     */
    public void addIngredient(){
        // Implementation will be added later
    }

    /**
     * Returns the kitchen to which the delivery is made.
     *
     * @return the kitchen to which the delivery is made
     */
    public Kitchen getKitchen() {
        return kitchen;
    }

    /**
     * Sets the kitchen to which the delivery is made.
     *
     * @param kitchen the new kitchen to which the delivery is made
     */
    public void setKitchen(Kitchen kitchen) {
        this.kitchen = kitchen;
    }

    /**
     * Returns the date of the delivery.
     *
     * @return the date of the delivery
     */
    public int getDate() {
        return date;
    }

    /**
     * Sets the date of the delivery.
     *
     * @param date the new date of the delivery
     */
    public void setDate(int date) {
        this.date = date;
    }
}
