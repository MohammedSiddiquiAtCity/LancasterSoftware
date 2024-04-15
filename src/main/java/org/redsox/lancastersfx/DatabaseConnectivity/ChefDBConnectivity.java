package org.redsox.lancastersfx.DatabaseConnectivity;

import java.sql.*;

public class ChefDBConnectivity extends ConnectivityDBImpl {

    public ChefDBConnectivity() {
    }

    public boolean isHeadChef(int chefId) {
        return checkChefRole(chefId, "Head Chef");
    }

    public boolean isSousChef(int chefId) {
        return checkChefRole(chefId, "Sous Chef");
    }

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
