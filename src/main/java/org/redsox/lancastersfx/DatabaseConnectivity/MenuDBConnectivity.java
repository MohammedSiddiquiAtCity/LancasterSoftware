package org.redsox.lancastersfx.DatabaseConnectivity;

import java.sql.*;

public class MenuDBConnectivity extends ConnectivityDBImpl {
    public MenuDBConnectivity() {
    }

    public void addDish(String dishName, int menuId) {
        // This method assumes that the dish already exists in the `Dish` table
        // and that you're adding it to an existing menu specified by `menuId`.
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = getConnection(getUsernameData(), getPasswordData());
            String insertDishMenuQuery = "INSERT INTO Dish_Menu (DishDISH_ID, MenuMENU_ID) VALUES ((SELECT DISH_ID FROM Dish WHERE DISH_NAME = ?), ?)";
            stmt = connection.prepareStatement(insertDishMenuQuery);
            stmt.setString(1, dishName);
            stmt.setInt(2, menuId);

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Adding dish to menu failed, no rows affected.");
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException ex) {
                System.out.println("Resource cleanup failed: " + ex.getMessage());
            }
        }
    }

    public void removeDish(String dishName, int menuId) {
        // This method removes a dish from a specific menu.
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = getConnection(getUsernameData(), getPasswordData());
            String deleteDishMenuQuery = "DELETE FROM Dish_Menu WHERE DishDISH_ID = (SELECT DISH_ID FROM Dish WHERE DISH_NAME = ?) AND MenuMENU_ID = ?";
            stmt = connection.prepareStatement(deleteDishMenuQuery);
            stmt.setString(1, dishName);
            stmt.setInt(2, menuId);

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Removing dish from menu failed, no rows affected.");
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException ex) {
                System.out.println("Resource cleanup failed: " + ex.getMessage());
            }
        }
    }
}
