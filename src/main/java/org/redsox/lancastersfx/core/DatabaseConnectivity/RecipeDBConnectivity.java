package org.redsox.lancastersfx.core.DatabaseConnectivity;

import org.redsox.lancastersfx.core.Ingredient;
import org.redsox.lancastersfx.core.Recipe;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class RecipeDBConnectivity extends ConnectivityDBImpl {

    public RecipeDBConnectivity() {
    }

    public void addRecipe(Recipe recipe) {
        try (Connection connection = getConnection(getUsernameData(), getPasswordData())) {
            // Insert recipe into Recipe table
            String insertRecipeSQL = "INSERT INTO Recipe (ChefCHEF_ID, RECIPE_NAME) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(insertRecipeSQL, Statement.RETURN_GENERATED_KEYS)) {
                statement.setInt(1, recipe.getCreatorID());
                statement.setString(2, recipe.getName());
                statement.executeUpdate();

                // Get auto-generated recipe ID
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int recipeId = generatedKeys.getInt(1);
                    recipe.setId(recipeId);

                    // Add ingredients to Ingredient_Recipe table
                    addIngredientsToRecipe(connection, recipe);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addIngredientsToRecipe(Connection connection, Recipe recipe) throws SQLException {
        String insertIngredientSQL = "INSERT INTO Ingredient_Recipe (IngredientINGREDIENT_ID, RecipeRECIPE_ID) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(insertIngredientSQL)) {
            for (Ingredient ingredient : recipe.getIngredient()) {
                statement.setInt(1, ingredient.getId());
                statement.setInt(2, recipe.getId());
                statement.addBatch();
            }
            statement.executeBatch();
        }
    }

    public void removeRecipe(Recipe recipe) {
        try (Connection connection = getConnection(getUsernameData(), getPasswordData())) {
            // Remove recipe from Recipe table
            String deleteRecipeSQL = "DELETE FROM Recipe WHERE RECIPE_ID = ?";
            try (PreparedStatement statement = connection.prepareStatement(deleteRecipeSQL)) {
                statement.setInt(1, recipe.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void reviewRecipe(Recipe recipe, boolean reviewed) {
        try (Connection connection = getConnection(getUsernameData(), getPasswordData())) {
            // Update review status of recipe
            String updateRecipeSQL = "UPDATE Recipe SET REVIEWED = ? WHERE RECIPE_ID = ?";
            try (PreparedStatement statement = connection.prepareStatement(updateRecipeSQL)) {
                statement.setBoolean(1, reviewed);
                statement.setInt(2, recipe.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void approveRecipe(Recipe recipe, boolean approved) {
        try (Connection connection = getConnection(getUsernameData(), getPasswordData())) {
            // Update approval status of recipe
            String updateRecipeSQL = "UPDATE Recipe SET APPROVED = ? WHERE RECIPE_ID = ?";
            try (PreparedStatement statement = connection.prepareStatement(updateRecipeSQL)) {
                statement.setBoolean(1, approved);
                statement.setInt(2, recipe.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addIngredient(Recipe recipe, Ingredient ingredient) {
        try (Connection connection = getConnection(getUsernameData(), getPasswordData())) {
            // Add ingredient to Ingredient_Recipe table
            String insertIngredientSQL = "INSERT INTO Ingredient_Recipe (IngredientINGREDIENT_ID, RecipeRECIPE_ID) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(insertIngredientSQL)) {
                statement.setInt(1, ingredient.getId());
                statement.setInt(2, recipe.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeIngredient(Recipe recipe, Ingredient ingredient) {
        try (Connection connection = getConnection(getUsernameData(), getPasswordData())) {
            // Remove ingredient from Ingredient_Recipe table
            String deleteIngredientSQL = "DELETE FROM Ingredient_Recipe WHERE IngredientINGREDIENT_ID = ? AND RecipeRECIPE_ID = ?";
            try (PreparedStatement statement = connection.prepareStatement(deleteIngredientSQL)) {
                statement.setInt(1, ingredient.getId());
                statement.setInt(2, recipe.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
