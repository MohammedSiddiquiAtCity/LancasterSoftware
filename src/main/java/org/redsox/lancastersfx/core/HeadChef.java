package org.redsox.lancastersfx.core;

public class HeadChef extends Chef {

    public HeadChef(String id, String name, Kitchen kitchen) {
        super(id, name, kitchen);
    }

    public void approveRecipe(int recipeID){
        getKitchen().approveRecipe(recipeID);
    }

    public void createMenu(Menu menu){
        getKitchen().createMenu(menu);
    }

    public void postDish(Dish dish){
        getKitchen().postDish(dish);
    }
}
