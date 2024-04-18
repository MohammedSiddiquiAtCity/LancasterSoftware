package org.redsox.lancastersfx.core;

/**
 * The SousChef class represents a sous chef in a kitchen.
 * It inherits properties and behaviors from the Chef class.
 */
public class SousChef extends Chef {

    /**
     * Constructs a SousChef object with the specified ID, name, and kitchen.
     *
     * @param id the ID of the sous chef
     * @param name the name of the sous chef
     * @param kitchen the kitchen associated with the sous chef
     */
    public SousChef(int id, String name, Kitchen kitchen) {
        super(id, name, kitchen);
    }

    /**
     * Reviews a recipe with the specified ID.
     * This method delegates the review operation to the kitchen.
     *
     * @param recipeID the ID of the recipe to review
     */
    public void reviewRecipe(int recipeID){
        getKitchen().reviewRecipe(recipeID);
    }

}
