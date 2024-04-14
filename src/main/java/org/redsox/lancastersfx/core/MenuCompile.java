package org.redsox.lancastersfx.core;

import java.util.ArrayList;
import java.util.List;

public class MenuCompile{
    // Initialize the menuList to hold Dish objects
    private List<Dish> menuList;

    // Constructor to initialize the menuList
    public MenuCompile() {
        this.menuList = new ArrayList<>();
    }

    // Method to add a dish to the menuList
    public void addDish(Dish dish) {
        menuList.add(dish);
    }

    // Method to retrieve a dish from the menuList based on its index
    public Dish getDish(int index) {
        if (index >= 0 && index < menuList.size()) {
            return menuList.get(index);
        } else {
            return null; // Return null if index is out of bounds
        }
    }

    // Method to return the entire menuList
    public List<Dish> getMenuList() {
        return menuList;
    }
}
