package org.redsox.lancastersfx.core;

import java.util.List;

public interface IFOHkit {
    DishAvailability getDishAvailability(String dishName);
    List<String> readyDishes(int orderID);

    class DishAvailability{
        private final boolean available;
        private final String name;

        public DishAvailability(boolean available, String name) {
            this.available = available;
            this.name = name;
        }

        public boolean isAvailable() {
            return available;
        }

        public String getName() {
            return name;
        }

    }

}
