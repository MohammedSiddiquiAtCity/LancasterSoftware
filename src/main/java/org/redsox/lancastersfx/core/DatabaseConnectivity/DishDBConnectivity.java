package org.redsox.lancastersfx.core.DatabaseConnectivity;

import org.redsox.lancastersfx.core.Dish;
import org.redsox.lancastersfx.core.Ingredient;
import org.redsox.lancastersfx.core.Recipe;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DishDBConnectivity extends ConnectivityDBImpl{

    public DishDBConnectivity() {
    }

    /**
     * @return List<Dish>
     * returns a list of dishes in the database with related recipes.
     */
    public List<Dish> getDishes(){
        ArrayList<Dish> dishes = new ArrayList<>();
        String name = "";
        Connection connection = getConnection(getUsernameData(), getPasswordData());
        try (Statement sta = connection.createStatement();
                 ResultSet resultSet = sta.executeQuery("SELECT * " +
                         "FROM Dish " +
                         "JOIN Dish_Recipe ON Dish.DISH_ID = Dish_Recipe.DishDISH_ID " +
                         "JOIN Recipe ON Dish_Recipe.RecipeRECIPE_ID = Recipe.RECIPE_ID; ")){
                while (resultSet.next()) {
                    if(resultSet.getString("DISH_NAME").equals(name)){
                       // Go through the dishes array and then add the recipe.
                       int creatorID = resultSet.getInt("ChefCHEF_ID");
                       String recipeName = resultSet.getString("RECIPE_NAME");
                       for(Dish dish : dishes){
                           if(dish.getName().equals(name)){
                               dish.addRecipe(new Recipe(recipeName,creatorID));
                           }
                       }
                       continue;
                    }
                    name = resultSet.getString("DISH_NAME");
                    String description = resultSet.getString("DISH_DESCRIPTION");
                    List<Recipe> recipes = new ArrayList<>();

                    int creatorID = resultSet.getInt("ChefCHEF_ID");
                    String recipeName = resultSet.getString("RECIPE_NAME");
                    recipes.add(new Recipe(recipeName, creatorID));
                    dishes.add(new Dish(name, description, recipes));
                }
                sta.close();
        }catch (SQLException sqle) {
            try {
                if (connection != null) {
                    connection.rollback(); // Rollback in case of any error
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            sqle.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.setAutoCommit(true); // Restore auto-commit mode
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dishes;
    }

    /**
     * @param dishName
     * The name of the dish to be added
     *
     * @param description
     * The description related to the dish
     *
     * @param recipesRequired
     * The list of recipes that the dish requires.
     * */
    public void addDish(String dishName, String description, ArrayList<Recipe> recipesRequired) {
        Connection connection = null;
        try {
            connection = getConnection(getUsernameData(), getPasswordData());
            connection.setAutoCommit(false); // Start transaction

            int dishId = insertDish(dishName, description);
            if (dishId == -1) {
                throw new SQLException("Failed to insert dish.");
            }

            for (Recipe recipe : recipesRequired) {
                int recipeId = insertRecipe(recipe);
                if (recipeId == -1) {
                    recipeId = getRecipeIdByName(recipe.getName());
                    if (recipeId == -1) {
                        throw new SQLException("Failed to insert or find recipe: " + recipe.getName());
                    }
                }
                insertDishRecipe(dishId, recipeId);
            }

            connection.commit();
        } catch (SQLException sqle) {
            String stateCode = sqle.getSQLState();
            switch (stateCode){
                case "23000":
                    System.out.println("Duplicate value found.");
                    break;
                default:
                    System.out.println("Unknown error.");
            }

            try {
                if (connection != null) {
                    connection.rollback(); // Rollback in case of any error
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            sqle.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.setAutoCommit(true);
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Helper methods to retrieve recipe ID by name,
    // these can only be used if there is already a connection to the database

    /**
     * @param dishName
     * the name of the dish to be found or added to the database.
     * @param description
     * the description realted to the dish.
     *
     * @return
     * The method returns the ID of the dish. If it doesn't exist, it will then add the dish to the database then return the ID related to the dish.
     * returns -1 if there was an error.
     * */
    private int insertDish(String dishName, String description) throws SQLException {
        String selectDishIdCommand = "SELECT DISH_ID FROM Dish WHERE DISH_NAME = ?";
        String insertDishCommand = "INSERT INTO Dish (DISH_NAME, DISH_DESCRIPTION) VALUES (?, ?)";
        Connection connection = getCon();
        try (PreparedStatement psta = connection.prepareStatement(selectDishIdCommand)) {
            psta.setString(1, dishName);
            ResultSet resultSet = psta.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("DISH_ID");
            } else {
                try (PreparedStatement pstaDish = connection.prepareStatement(insertDishCommand, Statement.RETURN_GENERATED_KEYS)) {
                    pstaDish.setString(1, dishName);
                    pstaDish.setString(2, description);
                    pstaDish.executeUpdate();

                    ResultSet generatedKeys = pstaDish.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1);
                    } else {
                        return -1;
                    }
                }
            }
        }
    }

    private int getRecipeIdByName(String recipeName) throws SQLException {
        String selectRecipeIdCommand = "SELECT RECIPE_ID FROM Recipe WHERE RECIPE_NAME = ?";
        Connection connection = getCon();
        try (PreparedStatement psta = connection.prepareStatement(selectRecipeIdCommand)) {
            psta.setString(1, recipeName);
            ResultSet resultSet = psta.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("RECIPE_ID");
            }
            throw new SQLException("Recipe not found: " + recipeName);
        }
    }

    private int insertRecipe(Recipe recipe) throws SQLException {
        String selectRecipeIdCommand = "SELECT RECIPE_ID FROM Recipe WHERE RECIPE_NAME = ?";
        String insertRecipeCommand = "INSERT INTO Recipe (RECIPE_NAME, ChefCHEF_ID) VALUES (?, ?)";
        Connection connection = getCon();
        try (PreparedStatement psta = connection.prepareStatement(selectRecipeIdCommand)) {
            psta.setString(1, recipe.getName());
            ResultSet resultSet = psta.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("RECIPE_ID");
            } else {
                try (PreparedStatement pstaRecipe = connection.prepareStatement(insertRecipeCommand, Statement.RETURN_GENERATED_KEYS)) {
                    pstaRecipe.setString(1, recipe.getName());
                    pstaRecipe.setInt(2, recipe.getCreatorID());
                    pstaRecipe.executeUpdate();

                    ResultSet generatedKeys = pstaRecipe.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1);
                    } else {
                        return -1;
                    }
                }
            }
        }
    }

    private void insertDishRecipe(int dishId, int recipeId) throws SQLException {
        String insertDishRecipeCommand = "INSERT INTO Dish_Recipe (DishDISH_ID, RecipeRECIPE_ID) VALUES (?, ?)";
        Connection connection = getCon();
        try (PreparedStatement psta = connection.prepareStatement(insertDishRecipeCommand)) {
            psta.setInt(1, dishId);
            psta.setInt(2, recipeId);
            psta.executeUpdate();
        }
    }


}
