package org.redsox.lancastersfx.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.redsox.lancastersfx.DatabaseConnectivity.ChefDBConnectivity;
import org.redsox.lancastersfx.core.Chef;

import java.io.IOException;


/**
 * Controller class for the login functionality in the LancasterSoftware GUI.
 */
public class LoginController {

    private final Main main = new Main();

    @FXML
    private TextField username;

    /**
     * Handles the action when the login button is pressed.
     *
     * @param event The action event triggered by the login button.
     * @throws IOException If an error occurs during the login process.
     */
    @FXML
    void LoginPressed(ActionEvent event) throws IOException {
        String username = this.username.getText();

        System.out.println(username);
        // Connect to the database and check if the user is actually there

        ChefDBConnectivity chDB = new ChefDBConnectivity();

        Chef chef = chDB.inDB(username, main.kitchen);
        if (chef != null) {
            main.switchToInventory();
        }else{
            System.out.println("NOT A VALID CHEF!");
        }
    }

}
