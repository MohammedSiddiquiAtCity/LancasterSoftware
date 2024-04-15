package org.redsox.lancastersfx.GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.redsox.lancastersfx.core.Kitchen;

import java.io.IOException;

public class Main extends Application {
    private Stage stage;
    private BorderPane root;
    public static Kitchen kitchen = new Kitchen();

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        this.stage.setTitle("LancasterSoftware");
        showMain();
    }

    public void showMain() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Main.class.getResource("LoginPage.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setFullScreen(true);
        stage.requestFocus();
        stage.setScene(scene);
        stage.show();

    }

    public void switchToLogin(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LoginPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setFullScreen(true);
        stage.requestFocus();
        stage.setScene(scene);
        stage.show();
    }
    public void switchToInventory(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Inventory page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setFullScreen(true);
        stage.requestFocus();
        stage.setScene(scene);
        stage.show();
    }
    public void switchToMenuSelection(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Menu page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setFullScreen(true);
        stage.requestFocus();
        stage.setScene(scene);
        stage.show();
    }
    public void switchToOrders(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Orders page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setFullScreen(true);
        stage.requestFocus();
        stage.setScene(scene);
        stage.show();
    }
    public void switchToRecipes(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Recipe page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setFullScreen(true);
        stage.requestFocus();
        stage.setScene(scene);
        stage.show();
    }
    public void switchToFeedback(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Feedback page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setFullScreen(true);
        stage.requestFocus();
        stage.setScene(scene);
        stage.show();
    }
    public void switchToDishes(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Dishes page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setFullScreen(true);
        stage.requestFocus();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}