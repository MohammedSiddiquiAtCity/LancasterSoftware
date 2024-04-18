package org.redsox.lancastersfx.core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The IMngmtKit interface represents the management operations of a kitchen.
 * It provides methods for accessing the current menu and its associated dishes.
 */
public interface IMngmtKit {

    /**
     * Gets the current menu of the kitchen.
     *
     * @return the current menu
     */
    Menu getCurrentMenu();

    /**
     * The Menu class represents a menu in the kitchen.
     * It contains a list of dishes and provides methods for accessing information about them.
     */
    class Menu{

        /** The list of dishes in the menu. */
        protected List<Dish> dishes;

        /**
         * Constructs a Menu object with the specified list of dishes.
         *
         * @param dishes the list of dishes in the menu
         */
        public Menu(List<Dish> dishes) {
            this.dishes = dishes;
        }

        /**
         * Retrieves all ingredients used in the menu.
         *
         * @return a set of all ingredients used in the menu
         */
        public Set<Ingredient> getAllIngredients(){
            Set<Ingredient> ingredients = new HashSet<>();
            for(Dish dish : dishes){
                ingredients.addAll(dish.getIngredients());
            }
            return ingredients;
        }

        /**
         * Retrieves the names of all dishes in the menu.
         *
         * @return a list of names of all dishes in the menu
         */
        public List<String> getDishNames(){
            ArrayList<String> dishNames = new ArrayList<>();
            for(Dish dish : dishes){
                dishNames.add(dish.getName());
            }
            return dishNames;
        }
    }

    /**
     * The Dish class represents a dish in the kitchen menu.
     * It contains a name and a list of ingredients required to prepare the dish.
     */
    class Dish{

        /** The name of the dish. */
        protected String name;

        /** The list of ingredients required to prepare the dish. */
        protected List<Ingredient> ingredients;

        /**
         * Constructs a Dish object with the specified name and list of ingredients.
         *
         * @param name the name of the dish
         * @param ingredients the list of ingredients required to prepare the dish
         */
        public Dish(String name, List<Ingredient> ingredients) {
            this.name = name;
            this.ingredients = ingredients;
        }

        /**
         * Returns the name of the dish.
         *
         * @return the name of the dish
         */
        public String getName() {
            return name;
        }

        /**
         * Returns the list of ingredients required to prepare the dish.
         *
         * @return the list of ingredients required to prepare the dish
         */
        public List<Ingredient> getIngredients() {
            return ingredients;
        }

    }

    /**
     * The Ingredient class represents an ingredient used in a dish.
     * It contains a name and an ID.
     */
    class Ingredient{

        /** The name of the ingredient. */
        protected String name;

        /** The ID of the ingredient. */
        protected int id;

        /**
         * Constructs an Ingredient object with the specified name.
         *
         * @param name the name of the ingredient
         */
        Ingredient(String name){
            this.name = name;
        }

        /**
         * Returns the name of the ingredient.
         *
         * @return the name of the ingredient
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the name of the ingredient.
         *
         * @param name the new name of the ingredient
         */
        public void setName(String name) {
            this.name = name;
        }

    }

}
