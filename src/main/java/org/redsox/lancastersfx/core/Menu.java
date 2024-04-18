package org.redsox.lancastersfx.core;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * The Menu class represents a menu in a restaurant.
 * It contains information about the menu ID, date, and the list of dishes included in the menu.
 */
public class Menu {

    /** The unique identifier of the menu. */
    private int menuId;

    /** The date of the menu. */
    private Date menuDate;

    /** The list of dishes included in the menu. */
    private List<Dish> dishes; // A list to hold Dish objects

    /**
     * Constructs a Menu object with the specified menu ID and date.
     *
     * @param menuId the unique identifier of the menu
     * @param menuDate the date of the menu
     */
    public Menu(int menuId, Date menuDate) {
        this.menuId = menuId;
        this.menuDate = menuDate;
        this.dishes = new ArrayList<>();
    }

    /**
     * Returns the menu ID.
     *
     * @return the menu ID
     */
    public int getMenuId() {
        return menuId;
    }

    /**
     * Sets the menu ID.
     *
     * @param menuId the new menu ID
     */
    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    /**
     * Returns the date of the menu.
     *
     * @return the date of the menu
     */
    public Date getMenuDate() {
        return menuDate;
    }

    /**
     * Sets the date of the menu.
     *
     * @param menuDate the new date of the menu
     */
    public void setMenuDate(Date menuDate) {
        this.menuDate = menuDate;
    }

    /**
     * Adds a dish to the menu.
     *
     * @param dish the dish to add to the menu
     */
    public void addDish(Dish dish) {
        this.dishes.add(dish);
    }

    /**
     * Removes a dish from the menu.
     *
     * @param dish the dish to remove from the menu
     */
    public void removeDish(Dish dish) {
        this.dishes.remove(dish);
    }

    /**
     * Returns the list of dishes included in the menu.
     *
     * @return the list of dishes included in the menu
     */
    public List<Dish> getDishes() {
        return dishes;
    }
}
