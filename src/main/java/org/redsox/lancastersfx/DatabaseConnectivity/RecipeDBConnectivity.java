package org.redsox.lancastersfx.DatabaseConnectivity;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class RecipeDBConnectivity extends ConnectivityDBImpl {

    public RecipeDBConnectivity() {
    }

    public void addRecipe(String recipeName, int chefId, HashMap<Integer, Float> ingredientAmountsMap) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet generatedKeys = null;

        try {
            connection = getConnection(getUsernameData(), getPasswordData());
            connection.setAutoCommit(false);

            // Insert into Recipe table
            String insertRecipe = "INSERT INTO Recipe (RECIPE_NAME, ChefCHEF_ID) VALUES (?, ?)";
            stmt = connection.prepareStatement(insertRecipe, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, recipeName);
            stmt.setInt(2, chefId);
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating recipe failed, no rows affected.");
            }

            int recipeId;
            generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                recipeId = generatedKeys.getInt(1);
            } else {
                throw new SQLException("Creating recipe failed, no ID obtained.");
            }

            // Insert into Ingredient_Recipe table
            String insertIngredientRecipe = "INSERT INTO Ingredient_Recipe (IngredientINGREDIENT_ID, RecipeRECIPE_ID, IngredientAmount) VALUES (?, ?, ?)";
            stmt = connection.prepareStatement(insertIngredientRecipe);

            for (Map.Entry<Integer, Float> entry : ingredientAmountsMap.entrySet()) {
                stmt.setInt(1, entry.getKey());
                stmt.setInt(2, recipeId);
                stmt.setFloat(3, entry.getValue());
                stmt.addBatch();
            }

            stmt.executeBatch();
            connection.commit();
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    System.err.println("Rollback failed: " + ex.getMessage());
                }
            }
            throw e;
        } finally {
            if (generatedKeys != null) generatedKeys.close();
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
    }

    public void removeRecipe(int recipeId) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = getConnection(getUsernameData(), getPasswordData());
            connection.setAutoCommit(false);

            // Delete associations in Ingredient_Recipe table
            String deleteIngredientRecipe = "DELETE FROM Ingredient_Recipe WHERE RecipeRECIPE_ID = ?";
            stmt = connection.prepareStatement(deleteIngredientRecipe);
            stmt.setInt(1, recipeId);
            stmt.executeUpdate();

            // Delete associations in Dish_Recipe table, if applicable
            String deleteDishRecipe = "DELETE FROM Dish_Recipe WHERE RecipeRECIPE_ID = ?";
            stmt = connection.prepareStatement(deleteDishRecipe);
            stmt.setInt(1, recipeId);
            stmt.executeUpdate();

            // Finally, delete the recipe itself
            String deleteRecipe = "DELETE FROM Recipe WHERE RECIPE_ID = ?";
            stmt = connection.prepareStatement(deleteRecipe);
            stmt.setInt(1, recipeId);
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("No recipe found with ID: " + recipeId);
            }

            connection.commit();
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    System.err.println("Rollback failed: " + ex.getMessage());
                }
            }
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
    }

    public boolean checkRecipeReviewal(int recipeId) throws SQLException {
        return checkRecipeStatus(recipeId, "reviewed");
    }

    public boolean checkRecipeApproval(int recipeId) throws SQLException {
        return checkRecipeStatus(recipeId, "approved");
    }

    private boolean checkRecipeStatus(int recipeId, String columnName) throws SQLException {
        String query = "SELECT " + columnName + " FROM Recipe WHERE RECIPE_ID = ?";
        try (
                Connection connection = getConnection(getUsernameData(), getPasswordData());
                PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, recipeId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getBoolean(columnName);
            } else {
                throw new SQLException("Recipe with ID " + recipeId + " does not exist.");
            }
        }
    }

    public void reviewRecipe(int recipeId, boolean reviewed) throws SQLException {
        updateRecipeStatus(recipeId, "reviewed", reviewed);
    }

    public void approveRecipe(int recipeId, boolean approved) throws SQLException {
        updateRecipeStatus(recipeId, "approved", approved);
    }

    private void updateRecipeStatus(int recipeId, String columnName, boolean status) throws SQLException {
        String query = "UPDATE Recipe SET " + columnName + " = ? WHERE RECIPE_ID = ?";
        try (
                Connection connection = getConnection(getUsernameData(), getPasswordData());
                PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setBoolean(1, status);
            stmt.setInt(2, recipeId);
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Updating status failed, no rows affected.");
            }
        }
    }

    public void adjustRecipe(int recipeId, Integer ingredientIdToAdd, Float amountToAdd, Integer ingredientIdToRemove) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = getConnection(getUsernameData(), getPasswordData());
            connection.setAutoCommit(false); // Start transaction

            // Add ingredient to the recipe
            if (ingredientIdToAdd != null && amountToAdd != null) {
                String insertIngredient = "INSERT INTO Ingredient_Recipe (RecipeRECIPE_ID, IngredientINGREDIENT_ID, IngredientAmount) VALUES (?, ?, ?)";
                stmt = connection.prepareStatement(insertIngredient);
                stmt.setInt(1, recipeId);
                stmt.setInt(2, ingredientIdToAdd);
                stmt.setFloat(3, amountToAdd);
                stmt.executeUpdate();
            }

            // Remove ingredient from the recipe
            if (ingredientIdToRemove != null) {
                String removeIngredient = "DELETE FROM Ingredient_Recipe WHERE RecipeRECIPE_ID = ? AND IngredientINGREDIENT_ID = ?";
                stmt = connection.prepareStatement(removeIngredient);
                stmt.setInt(1, recipeId);
                stmt.setInt(2, ingredientIdToRemove);
                stmt.executeUpdate();
            }

            connection.commit(); // Commit transaction if all operations are successful
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback(); // Roll back transaction in case of error
                } catch (SQLException ex) {
                    System.err.println("Rollback failed: " + ex.getMessage());
                }
            }
            throw e; // Re-throw the exception to be handled elsewhere
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
    }
}
