package org.redsox.lancastersfx.DatabaseConnectivity;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;


/**
 * The RecipeDBConnectivity class extends ConnectivityDBImpl and provides methods for managing recipes
 * in the database, including adding, removing, reviewing, approving, and adjusting recipes.
 */
public class RecipeDBConnectivity extends ConnectivityDBImpl {

    /**
     * Constructs a RecipeDBConnectivity object.
     */
    public RecipeDBConnectivity() {
    }

    /**
     * Adds a recipe to the database with the specified name, chef ID, and ingredient amounts.
     *
     * @param recipeName The name of the recipe.
     * @param chefId The ID of the chef who created the recipe.
     * @param ingredientAmountsMap A map containing ingredient IDs as keys and their respective amounts as values.
     * @throws SQLException If a database access error occurs or the SQL execution fails.
     */
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

    /**
     * Removes a recipe from the database with the specified recipe ID.
     *
     * @param recipeId The ID of the recipe to remove.
     * @throws SQLException If a database access error occurs or the SQL execution fails.
     */
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

    /**
     * Checks whether a recipe with the specified ID has been reviewed.
     *
     * @param recipeId The ID of the recipe to check.
     * @return true if the recipe has been reviewed; otherwise, false.
     * @throws SQLException If a database access error occurs or the SQL execution fails.
     */
    public boolean checkRecipeReviewal(int recipeId) throws SQLException {
        return checkRecipeStatus(recipeId, "reviewed");
    }

    /**
     * Checks whether a recipe with the specified ID has been approved.
     *
     * @param recipeId The ID of the recipe to check.
     * @return true if the recipe has been approved; otherwise, false.
     * @throws SQLException If a database access error occurs or the SQL execution fails.
     */
    public boolean checkRecipeApproval(int recipeId) throws SQLException {
        return checkRecipeStatus(recipeId, "approved");
    }

    /**
     * Checks the status of a recipe.
     *
     * @param recipeId   The ID of the recipe to check.
     * @param columnName The name of the column representing the status.
     * @return true if the recipe has the specified status; false otherwise.
     * @throws SQLException If an SQL exception occurs during the operation.
     */
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

    /**
     * Reviews a recipe, updating its review status.
     *
     * @param recipeId The ID of the recipe to review.
     * @param reviewed The new review status of the recipe.
     * @throws SQLException If an SQL exception occurs during the operation.
     */
    public void reviewRecipe(int recipeId, boolean reviewed) throws SQLException {
        updateRecipeStatus(recipeId, "reviewed", reviewed);
    }

    /**
     * Approves a recipe, updating its approval status.
     *
     * @param recipeId The ID of the recipe to approve.
     * @param approved The new approval status of the recipe.
     * @throws SQLException If an SQL exception occurs during the operation.
     */
    public void approveRecipe(int recipeId, boolean approved) throws SQLException {
        updateRecipeStatus(recipeId, "approved", approved);
    }

    /**
     * Updates the status of a recipe.
     *
     * @param recipeId   The ID of the recipe to update.
     * @param columnName The name of the column representing the status.
     * @param status     The new status value.
     * @throws SQLException If an SQL exception occurs during the operation.
     */
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

    /**
     * Adjusts a recipe by adding or removing ingredients.
     *
     * @param recipeId            The ID of the recipe to adjust.
     * @param ingredientIdToAdd   The ID of the ingredient to add (null if no ingredient is to be added).
     * @param amountToAdd         The amount of the ingredient to add (null if no ingredient is to be added).
     * @param ingredientIdToRemove The ID of the ingredient to remove (null if no ingredient is to be removed).
     * @throws SQLException If an SQL exception occurs during the operation.
     */
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
