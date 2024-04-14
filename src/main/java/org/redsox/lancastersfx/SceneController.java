package org.redsox.lancastersfx;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Parent;

import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SceneController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ComboBox UserDropdown = new ComboBox();

    @FXML
    private Label label = new Label();

    @FXML
    void Select(ActionEvent event){
        String s = UserDropdown.getSelectionModel().getSelectedItem().toString();
        label.setText(s);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> list = FXCollections.observableArrayList("Billy Jean", "Micheal LaFosse", "Anna Polina");
        UserDropdown.setItems(list);

        




    }

    public void switchToLogin(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LoginPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new javafx.scene.Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToInventory(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Inventory page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new javafx.scene.Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToMenuSelection(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Menu page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new javafx.scene.Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToOrders(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Orders page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new javafx.scene.Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToRecipes(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Recipe page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new javafx.scene.Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToFeedback(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Feedback page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new javafx.scene.Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToDishes(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Dishes page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new javafx.scene.Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.show();
    }
}
