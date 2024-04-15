package org.redsox.lancastersfx.DatabaseConnectivity;

import org.redsox.lancastersfx.core.Dish;
import org.redsox.lancastersfx.core.Ingredient;
import org.redsox.lancastersfx.core.Recipe;

import java.util.ArrayList;
import java.util.List;

public class DBTesting {
    public static void main(String[] args) {
        DishDBConnectivity db = new DishDBConnectivity();

        List<Dish> dishes = db.getDishes();

//
//        List<Dish> dishes = db.getDishes();
//
//        for (Dish dish: dishes) {
//            System.out.println(dish.getName());
//            System.out.println(dish.getDescription());
//            List<Recipe> recipes = dish.getRecipes();
//            for(Recipe r : recipes){
//                System.out.println(r.getName());
//            }
//            System.out.println("======================");
//        }
//        ArrayList<Recipe> recipes = new ArrayList<>();
//        recipes.add(new Recipe("Medium Rare Steak", 1));
//        recipes.add(new Recipe("Mashed Potato", 2));
//
//        db.addDish("Steak and Mashed Potato", "A simple but flavourful classic!", recipes);
        InventoryDBConnectivity ib = new InventoryDBConnectivity();
       // ib.addStock("kopi luwak", 10, "20241231");
        Ingredient cake = new Ingredient();
       // ib.removeStock(cake, 1, 0);
        ChefDBConnectivity chef = new ChefDBConnectivity();
        ChefDBConnectivity chefDB = new ChefDBConnectivity();

        // Example chef ID, you would get this from your application context
        int chefId = 4; // Replace with a valid chef ID from your database

        // Check if the chef is a head chef
        boolean isHeadChef = chefDB.isHeadChef(chefId);
        System.out.println("Chef with ID " + chefId + " is head chef: " + isHeadChef);

        // Check if the chef is a sous chef
        boolean isSousChef = chefDB.isSousChef(chefId);
        System.out.println("Chef with ID " + chefId + " is sous chef: " + isSousChef);
    }
}

