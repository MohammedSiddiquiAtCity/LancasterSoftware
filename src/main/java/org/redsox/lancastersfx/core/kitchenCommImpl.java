package org.redsox.lancastersfx.core;

import java.util.List;

/**
 * The kitchenCommImpl class implements communication interfaces for kitchen management and front-of-house operations.
 * It provides methods for retrieving the current menu, checking dish availability, and retrieving ready dishes.
 */
public class kitchenCommImpl implements IMngmtKit, IFOHkit {

    /**
     * Retrieves the current menu.
     *
     * @return the current menu
     */
    @Override
    public Menu getCurrentMenu() {
        return null; // Implementation will be added later
    }

    /**
     * Retrieves the availability of a dish by its name.
     *
     * @param dishName the name of the dish to check availability for
     * @return the availability of the dish
     */
    @Override
    public DishAvailability getDishAvailability(String dishName) {
        return null; // Implementation will be added later
    }

    /**
     * Retrieves a list of dishes that are ready for a given order ID.
     *
     * @param orderID the ID of the order for which to retrieve ready dishes
     * @return a list of names of dishes that are ready for the order
     */
    @Override
    public List<String> readyDishes(int orderID) {
        return null; // Implementation will be added later
    }
}
