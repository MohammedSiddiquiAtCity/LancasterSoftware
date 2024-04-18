package org.redsox.lancastersfx.core;

/**
 * The HeadChef class represents a head chef in a restaurant.
 * A head chef is a specialized type of chef responsible for managing the kitchen.
 */
public class HeadChef extends Chef {

    /**
     * Constructs a HeadChef object with the specified id, name, and kitchen.
     *
     * @param id the unique identifier of the head chef
     * @param name the name of the head chef
     * @param kitchen the kitchen where the head chef works
     */
    public HeadChef(int id, String name, Kitchen kitchen) {
        super(id, name, kitchen);
    }

    /**
     * Approves a recipe with the specified ID.
     * This method delegates the approval of the recipe to the kitchen.
     *
     * @param recipeID the ID of the recipe to approve
     */
    public void approveRecipe(int recipeID){
        getKitchen().approveRecipe(recipeID);
    }

    /**
     * Posts a dish to the kitchen.
     * This method delegates the posting of the dish to the kitchen.
     *
     * @param dish the dish to be posted
     */
    public void postDish(Dish dish){
        getKitchen().postDish(dish);
    }

    // Uncomment this method if Menu class is available and needed
    // /**
    //  * Creates a menu in the kitchen.
    //  * This method delegates the creation of the menu to the kitchen.
    //  *
    //  * @param menu the menu to create
    //  */
    // public void createMenu(Menu menu){
    //     getKitchen().createMenu(menu);
    // }
}
