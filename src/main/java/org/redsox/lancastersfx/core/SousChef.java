package org.redsox.lancastersfx.core;

public class SousChef extends Chef {

    public SousChef(String id, String name, Kitchen kitchen) {
        super(id, name, kitchen);
    }

    public void reviewRecipe(int recipeID){
        getKitchen().reviewRecipe(recipeID);
    }

}
