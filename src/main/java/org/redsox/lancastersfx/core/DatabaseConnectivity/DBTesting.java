package org.redsox.lancastersfx.core.DatabaseConnectivity;

import org.redsox.lancastersfx.core.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBTesting {
    public static void main(String[] args) throws SQLException {
        DishDBConnectivity db = new DishDBConnectivity();


        List<Dish> dishes = db.getDishes();
        db.addIngredientToDish(1,4);
        db.removeIngredientFromDish(1,1);
        //List<Ingredient> ingredients = db.g

        for (Dish dish: dishes) {
            System.out.println(dish.getName());
            System.out.println(dish.getDescription());
            List<Recipe> recipes = dish.getRecipes();
            for(Recipe r : recipes){
                System.out.println(r.getName());
            }
            System.out.println("======================");
        }
        ArrayList<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe("Medium Rare Steak", 1));
        recipes.add(new Recipe("Mashed Potato", 2));


        db.addDish("Steak and Mashed Potato", "A simple but flavourful classic!", recipes);
    }
}
