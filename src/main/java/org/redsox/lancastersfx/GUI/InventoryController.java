package org.redsox.lancastersfx.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

import java.io.IOException;

public class InventoryController {
    private Main main;

    @FXML
    private ListView listOfIngredients;

    @FXML
    private ComboBox removalReason;

    @FXML
    void Submit(ActionEvent event) {

    }

    @FXML
    void decreaseStock(ActionEvent event) {

    }

    @FXML
    void increaseStock(ActionEvent event) {

    }
    
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
