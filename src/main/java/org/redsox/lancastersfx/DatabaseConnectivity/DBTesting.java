package org.redsox.lancastersfx.DatabaseConnectivity;

import org.redsox.lancastersfx.core.Dish;
import org.redsox.lancastersfx.core.Recipe;

import java.sql.SQLException;
import java.util.List;
/**
 * Testing platform of database connections.
 * */
public class DBTesting {
    /**
     * @throws SQLException If an SQL exception occurs during the operation.
     * */
    public static void main(String[] args) throws SQLException {
        // Create a new instance of each database connectivity class
        DishDBConnectivity dishDb = new DishDBConnectivity();
        ChefDBConnectivity chefDb = new ChefDBConnectivity();
        InventoryDBConnectivity inventoryDb = new InventoryDBConnectivity();
        MenuDBConnectivity menuDb = new MenuDBConnectivity();
        RecipeDBConnectivity recipeDb = new RecipeDBConnectivity();

        // Fetch and print all dishes
        List<Dish> dishes = dishDb.getDishes();
        for (Dish dish : dishes) {
            System.out.println("Dish: " + dish.getName() + " - " + dish.getDescription());
            // For each dish, print its recipes
            for (Recipe recipe : dish.getRecipes()) {
                System.out.println("  Recipe: " + recipe.getName());
            }
        }

        // Example of checking if a chef is a head chef
        boolean isHeadChef = chefDb.isHeadChef(1);
        System.out.println("Is Chef ID 1 a head chef? " + isHeadChef);

        // Example of adding stock to the inventory
        inventoryDb.addStock("Coffee Beans", 100, "20231231");

        // Example of adding a dish to a menu
        menuDb.addDish("New Dish", 1);

    }
}