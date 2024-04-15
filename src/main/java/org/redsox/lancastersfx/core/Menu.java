package org.redsox.lancastersfx.core;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private int menuId;
    private Date menuDate; // Assuming you have an appropriate import for Date
    private List<Dish> dishes; // A list to hold Dish objects

    // Constructor
    public Menu(int menuId, Date menuDate) {
        this.menuId = menuId;
        this.menuDate = menuDate;
        this.dishes = new ArrayList<>();
    }

    // Getter and setter for menuId
    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    // Getter and setter for menuDate
    public Date getMenuDate() {
        return menuDate;
    }

    public void setMenuDate(Date menuDate) {
        this.menuDate = menuDate;
    }

    // Methods to manage dishes
    public void addDish(Dish dish) {
        this.dishes.add(dish);
    }

    public void removeDish(Dish dish) {
        this.dishes.remove(dish);
    }

    public List<Dish> getDishes() {
        return dishes;
    }
}

