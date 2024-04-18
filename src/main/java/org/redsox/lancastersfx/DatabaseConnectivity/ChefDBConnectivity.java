package org.redsox.lancastersfx.DatabaseConnectivity;

import org.redsox.lancastersfx.core.Chef;
import org.redsox.lancastersfx.core.HeadChef;
import org.redsox.lancastersfx.core.Kitchen;
import org.redsox.lancastersfx.core.SousChef;

import java.sql.*;

/**
 * The ChefDBConnectivity class provides methods for connecting to the database and retrieving chef information.
 */
public class ChefDBConnectivity extends ConnectivityDBImpl{

    /**
     * Constructs a ChefDBConnectivity object.
     */
    public ChefDBConnectivity() {
    }

    /**
     * Retrieves a Chef object from the database based on the chef's name.
     *
     * @param chefName the name of the chef to retrieve
     * @param kitchen the kitchen associated with the chef
     * @return the Chef object retrieved from the database
     */
    public Chef inDB(String chefName, Kitchen kitchen) {
        Chef chef = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Establishing connection
            connection = getConnection(getUsernameData(), getPasswordData());

            // SQL query to retrieve Chef information based on name
            String query = "SELECT *" +
                    "FROM Chef " +
                    "WHERE CHEF_NAME = ?";

            // Creating PreparedStatement
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, chefName);

            // Executing query
            resultSet = preparedStatement.executeQuery();

            // Processing result
            if (resultSet.next()) {
                int chefId = resultSet.getInt("CHEF_ID");
                String chefNameResult = resultSet.getString("CHEF_NAME");
                int roleId = resultSet.getInt("RoleROLE_ID");

                if(roleId == 1){
                    chef = new Chef(chefId, chefNameResult, kitchen);
                } else if (roleId == 2) {
                    chef = new SousChef(chefId, chefNameResult, kitchen);
                }else if (roleId == 3) {
                    chef = new HeadChef(chefId, chefNameResult, kitchen);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log exception
        } finally {
            // Closing resources
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace(); // Handle or log exception
            }
        }

        return chef;

    }

    /**
     * Checks if a chef with the given ID is a head chef.
     *
     * @param chefId the ID of the chef to check
     * @return true if the chef is a head chef, false otherwise
     */
    public boolean isHeadChef(int chefId) {
        return checkChefRole(chefId, "Head Chef");
    }

    /**
     * Checks if a chef with the given ID is a sous chef.
     *
     * @param chefId the ID of the chef to check
     * @return true if the chef is a sous chef, false otherwise
     */
    public boolean isSousChef(int chefId) {
        return checkChefRole(chefId, "Sous Chef");
    }

    /**
     * Checks if a chef with the given ID has the specified role.
     *
     * @param chefId the ID of the chef to check
     * @param roleName the name of the role to check
     * @return true if the chef has the specified role, false otherwise
     */
    private boolean checkChefRole(int chefId, String roleName) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean isRole = false;

        try {
            connection = getConnection(getUsernameData(), getPasswordData());
            String roleQuery = "SELECT COUNT(1) FROM Chef JOIN Role ON Chef.RoleROLE_ID = Role.ROLE_ID WHERE CHEF_ID = ? AND ROLE_NAME = ?";
            stmt = connection.prepareStatement(roleQuery);
            stmt.setInt(1, chefId);
            stmt.setString(2, roleName);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                isRole = count > 0;
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException ex) {
                System.out.println("Resource cleanup failed: " + ex.getMessage());
            }
        }
        return isRole;
    }
}
