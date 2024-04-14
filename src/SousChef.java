package src;

public class SousChef extends Chef {

    public SousChef(String id, String name, String email, Kitchen kitchen) {
        super(id, name, email, kitchen);
    }

    public void reviewRecipe(int recipeID){
        getKitchen().reviewRecipe(recipeID);
    }

}
