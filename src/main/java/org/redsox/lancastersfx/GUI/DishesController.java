package org.redsox.lancastersfx.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.redsox.lancastersfx.DatabaseConnectivity.DishDBConnectivity;
import org.redsox.lancastersfx.core.Dish;

import java.io.IOException;
import java.util.List;

public class DishesController {
    private Main main;
    private List<Dish> dishes;
    private int currentDishIndex = 0;

    @FXML
    private TextField dishNameField;

    @FXML
    private TextArea dishDescriptionArea;

    @FXML
    private Button previousButton;

    @FXML
    private Button nextButton;

    @FXML
    private Button viewFeedbackButton;

    @FXML
    private TextField additionalTextField;

    @FXML
    private void initialize() {
        try {
            DishDBConnectivity db = new DishDBConnectivity();
            dishes = db.getDishes();
            Dish currentDish = dishes.get(currentDishIndex);
            dishNameField.setText(currentDish.getName());
            dishDescriptionArea.setText(currentDish.getDescription());
            updateDishDisplay();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void showNextDish(ActionEvent event) {
        if (currentDishIndex < dishes.size() - 1) {
            currentDishIndex++;
            updateDishDisplay();
        }
    }

    @FXML
    void showPreviousDish(ActionEvent event) {
        if (currentDishIndex > 0) {
            currentDishIndex--;
            updateDishDisplay();
        }
    }

    @FXML
    void updateDishDisplay() {
        Dish currentDish = dishes.get(currentDishIndex);
        dishNameField.setText(currentDish.getName());
        dishDescriptionArea.setText(currentDish.getDescription());

        previousButton.setDisable(currentDishIndex <= 0);
        nextButton.setDisable(currentDishIndex >= dishes.size() - 1);
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

    @FXML
    void switchToFeedback(ActionEvent event) throws IOException {
        Main.switchToFeedback();
    }

}