package org.redsox.lancastersfx.core;

import java.util.List;

/**
 * The Dish class represents a dish in a restaurant menu.
 * Each dish has a name, description, and a list of recipes required to prepare it.
 */
public class Dish {

    /** The name of the dish. */
    private String name;

    /** The description of the dish. */
    private String description;

    /** The list of recipes required to prepare the dish. */
    private List<Recipe> recipes;

    /**
     * Constructs a Dish object with the specified name, description, and recipes.
     *
     * @param name the name of the dish
     * @param description the description of the dish
     * @param recipes the list of recipes required to prepare the dish
     */
    public Dish(String name, String description, List<Recipe> recipes) {
        this.name = name;
        this.description = description;
        this.recipes = recipes;
    }

    /**
     * Retrieves feedback for the dish from the website.
     * This method retrieves feedback for the dish from the website.
     *
     * @return a string containing the feedback for the dish
     */
    public String viewFeedback(){
        // Implementation to retrieve feedback from the website will be added later
        return "";
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
     * Sets the name of the dish.
     *
     * @param name the new name of the dish
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the description of the dish.
     *
     * @return the description of the dish
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the dish.
     *
     * @param description the new description of the dish
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the list of recipes required to prepare the dish.
     *
     * @return the list of recipes required to prepare the dish
     */
    public List<Recipe> getRecipes() {
        return recipes;
    }

    /**
     * Sets the list of recipes required to prepare the dish.
     *
     * @param recipes the new list of recipes required to prepare the dish
     */
    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    /**
     * Adds a recipe to the list of recipes required to prepare the dish.
     *
     * @param recipe the recipe to add
     */
    public void addRecipe(Recipe recipe){
        recipes.add(recipe);
    }

    /**
     * Returns a string representation of the dish.
     *
     * @return a string representation of the dish
     */
    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", recipes=" + recipes +
                '}';
    }
}
