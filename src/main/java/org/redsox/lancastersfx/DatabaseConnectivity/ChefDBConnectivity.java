package org.redsox.lancastersfx.DatabaseConnectivity;

import org.redsox.lancastersfx.core.Chef;
import org.redsox.lancastersfx.core.HeadChef;
import org.redsox.lancastersfx.core.Kitchen;
import org.redsox.lancastersfx.core.SousChef;

import java.sql.*;

public class ChefDBConnectivity extends ConnectivityDBImpl{

    public ChefDBConnectivity() {
    }

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

    public boolean isHeadChef(){
        return true;
    }

    public boolean isSousChef(){
        return true;
    }


}
