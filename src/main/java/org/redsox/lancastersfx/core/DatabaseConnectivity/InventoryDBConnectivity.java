package org.redsox.lancastersfx.core.DatabaseConnectivity;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class InventoryDBConnectivity extends ConnectivityDBImpl {

    public InventoryDBConnectivity() {

    }
    public void addIngredient(String ingredientName) {
        Connection connection = null;
        try {
            connection = getConnection(getUsernameData(), getPasswordData());
            connection.setAutoCommit(false); // Start transaction

            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Stock (STOCK_ID) VALUES (?)")) {
                preparedStatement.setString(1, ingredientName);
                preparedStatement.executeUpdate();
            }

            connection.commit();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            try {
                if (connection != null) {
                    connection.rollback(); // Rollback in case of any error
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
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


    public void addStock(){

    }

    public void removeStock(){

    }
}
