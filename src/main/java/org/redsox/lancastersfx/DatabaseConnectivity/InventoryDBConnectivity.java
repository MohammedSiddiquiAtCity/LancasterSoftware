package org.redsox.lancastersfx.DatabaseConnectivity;

import org.redsox.lancastersfx.core.Ingredient;

import java.sql.*;

public class InventoryDBConnectivity extends ConnectivityDBImpl {


    public InventoryDBConnectivity() {

    }
    private int convertStringToSqlDate(String dateString) {
        return Integer.parseInt(dateString);  // Converts string to java.sql.Date directly
    }
    /**
     * Adds stock to the inventory.
     *
     * @param stockName The name of the stock item.
     * @param quantity The quantity of the stock item.
     * @param expDate The expiration date of the stock item in format 'YYYY-MM-DD'.
     */
    public void addStock(String stockName, int quantity, String expDate) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            connection = getConnection(getUsernameData(), getPasswordData());
            connection.setAutoCommit(false); // Start transaction

            // Insert into Stock table
            String insertStockQuery = "INSERT INTO Stock (quantity, EXPIRY_DATE) VALUES (?, ?)";
            stmt = connection.prepareStatement(insertStockQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, quantity);
            stmt.setInt(2, convertStringToSqlDate(expDate));
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating stock failed, no rows affected.");
            }

            // Retrieve the generated stock ID
            int stockId;
            try (ResultSet rst = stmt.getGeneratedKeys()) {
                if (rst.next()) {
                    stockId = rst.getInt(1);
                    System.out.println("Generated Stock ID: " + stockId);
                } else {
                    throw new SQLException("Creating stock failed, no ID obtained.");
                }
            }

            // Check if Ingredient exists and insert if not
            String selectIngredientQuery = "SELECT INGREDIENT_ID FROM Ingredient WHERE INGREDIENT_NAME = ?";
            stmt = connection.prepareStatement(selectIngredientQuery);
            stmt.setString(1, stockName);
            rs = stmt.executeQuery();
            int ingredientId = 0;
            if (rs.next()) {
                ingredientId = rs.getInt(1);
            } else {
                // Insert new ingredient
                String insertIngredientQuery = "INSERT INTO Ingredient (INGREDIENT_NAME) VALUES (?)";
                stmt = connection.prepareStatement(insertIngredientQuery, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, stockName);
                stmt.executeUpdate();
                rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    ingredientId = rs.getInt(1);
                } else {
                    throw new SQLException("Creating ingredient failed, no ID obtained.");
                }
            }

            // Link stock with ingredient in the mapping table
            String insertStockIngredientQuery = "INSERT INTO Stock_Ingredient (StockSTOCK_ID, IngredientINGREDIENT_ID) VALUES (?, ?)";
            stmt = connection.prepareStatement(insertStockIngredientQuery);
            stmt.setInt(1, stockId);
            stmt.setInt(2, ingredientId);
            stmt.executeUpdate();

            connection.commit(); // Commit the transaction
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback(); // Roll back transaction on error
                } catch (SQLException ex) {
                    System.out.println("Rollback failed: " + ex.getMessage());
                }
            }
            System.out.println("SQLException: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (connection != null) {
                    connection.setAutoCommit(true); // Reset auto-commit to true
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println("Resource cleanup failed: " + ex.getMessage());
            }
        }
    }

//    public void removeStock(Ingredient ingredient, int quantity, int reason){
//        //Finds the correct ingredient and remove the quantity to it.
//        // It will ask whether what the reason for removing stock is:
//        // 0 - Using for a dish
//        // 1 - Damaged
//        // 2 - Rotting
//        // 3 - Bad Quality
//        // Then add that to the Waste table.
//    }
public void removeStock(Ingredient ingredient, int quantity, int reason) {
    Connection connection = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
        connection = getConnection(getUsernameData(), getPasswordData());
        connection.setAutoCommit(false); // Start transaction

        // Find the stock ID for the ingredient
        String selectStockQuery = "SELECT STOCK_ID, QUANTITY FROM Stock_Ingredient JOIN Stock ON StockSTOCK_ID = STOCK_ID WHERE IngredientINGREDIENT_ID = ?";
        stmt = connection.prepareStatement(selectStockQuery);
        stmt.setInt(1, ingredient.getId());
        rs = stmt.executeQuery();

        if (rs.next()) {
            int stockId = rs.getInt("STOCK_ID");
            int currentQuantity = rs.getInt("QUANTITY");
            int newQuantity = currentQuantity - quantity;

            // Update stock quantity or remove stock entry if quantity is zero or less
            if (newQuantity > 0) {
                String updateStockQuery = "UPDATE Stock SET QUANTITY = ? WHERE STOCK_ID = ?";
                stmt = connection.prepareStatement(updateStockQuery);
                stmt.setInt(1, newQuantity);
                stmt.setInt(2, stockId);
                stmt.executeUpdate();
            } else {
                String deleteStockQuery = "DELETE FROM Stock WHERE STOCK_ID = ?";
                stmt = connection.prepareStatement(deleteStockQuery);
                stmt.setInt(1, stockId);
                stmt.executeUpdate();
            }

            // Insert entry into Waste table
            String insertWasteQuery = "INSERT INTO Waste (IngredientINGREDIENT_ID, QUANTITY, ReasonREASON_ID) VALUES (?, ?, ?)";
            stmt = connection.prepareStatement(insertWasteQuery);
            stmt.setInt(1, ingredient.getId());
            stmt.setInt(2, quantity);
            stmt.setInt(3, reason);
            stmt.executeUpdate();
        } else {
            throw new SQLException("Ingredient not found in stock.");
        }

        connection.commit(); // Commit the transaction
    } catch (SQLException e) {
        if (connection != null) {
            try {
                connection.rollback(); // Roll back transaction on error
            } catch (SQLException ex) {
                System.out.println("Rollback failed: " + ex.getMessage());
            }
        }
        System.out.println("SQLException: " + e.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (connection != null) {
                connection.setAutoCommit(true); // Reset auto-commit to true
                connection.close();
            }
        } catch (SQLException ex) {
            System.out.println("Resource cleanup failed: " + ex.getMessage());
        }
    }
}


    public void addIngredient(){

    }


}
