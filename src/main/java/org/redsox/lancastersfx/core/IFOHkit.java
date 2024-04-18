package org.redsox.lancastersfx.core;

import java.util.List;

/**
 * The IFOHkit interface represents the front-of-house (FOH) kitchen operations.
 * It defines methods for checking dish availability and retrieving ready dishes.
 */
public interface IFOHkit {

    /**
     * Gets the availability of a dish by its name.
     *
     * @param dishName the name of the dish to check availability for
     * @return the availability of the dish
     */
    DishAvailability getDishAvailability(String dishName);

    /**
     * Retrieves a list of dishes that are ready for a given order ID.
     *
     * @param orderID the ID of the order for which to retrieve ready dishes
     * @return a list of names of dishes that are ready for the order
     */
    List<String> readyDishes(int orderID);

    /**
     * The DishAvailability class represents the availability status of a dish.
     * It contains information about whether the dish is available and its name.
     */
    class DishAvailability{

        /** Whether the dish is available or not. */
        private final boolean available;

        /** The name of the dish. */
        private final String name;

        /**
         * Constructs a DishAvailability object with the specified availability and name.
         *
         * @param available true if the dish is available, false otherwise
         * @param name the name of the dish
         */
        public DishAvailability(boolean available, String name) {
            this.available = available;
            this.name = name;
        }

        /**
         * Returns whether the dish is available.
         *
         * @return true if the dish is available, false otherwise
         */
        public boolean isAvailable() {
            return available;
        }

        /**
         * Returns the name of the dish.
         *
         * @return the name of the dish
         */
        public String getName() {
            return name;
        }

    }

}
