package org.redsox.lancastersfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LoginController {

    @FXML
    private Button LoginButton;

    @FXML
    void Login(ActionEvent event) {
        System.out.println("I GOT PRESSED");
    }

}
