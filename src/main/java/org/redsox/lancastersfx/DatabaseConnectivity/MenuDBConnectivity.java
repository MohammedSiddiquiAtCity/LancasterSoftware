package org.redsox.lancastersfx.DatabaseConnectivity;

public class MenuDBConnectivity extends ConnectivityDBImpl {
    public MenuDBConnectivity() {
    }

    /*
    tables to access:
    - dish
    tables affected:
    - DISH_MENU
    - Menu
    * */
    public void addDish(String dishName) {
        // with dish name, Need to retrieve DishID from DISH
        Connection connection = null;
        String selectDishIdCommand = "SELECT DISH_ID FROM Dish WHERE DISH_NAME = "+dishName;
        try {
            connection = getConnection(getUsernameData(), getPasswordData());
            connection.setAutoCommit(false); // Start transaction

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void removeDish(String dishName) {

    }
}

