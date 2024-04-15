package org.redsox.lancastersfx.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class InventoryController {
    private Main main;
    @FXML
    void switchToDishes(ActionEvent event) throws IOException {
        Main.switchToDishes();
    }

    @FXML
    void switchToInventory(ActionEvent event) throws IOException {
        Main.switchToInventory();
    }

    @FXML
    void switchToOrders(ActionEvent event) throws IOException {
        Main.switchToOrders();
    }

    @FXML
    void switchToRecipes(ActionEvent event) throws IOException {
        Main.switchToRecipes();
    }
}
