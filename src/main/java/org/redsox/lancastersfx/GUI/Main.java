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
    private static Stage stage;
    private static BorderPane root;
    public Kitchen kitchen = new Kitchen();

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
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();

    }

    public static void switchToLogin() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LoginPage.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public static void switchToInventory() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Inventory page.fxml"));
        BorderPane borderPane = fxmlLoader.load();
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }
    public static void switchToMenuSelection() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Menu page.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public static void switchToOrders() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Orders page.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public static void switchToRecipes() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Recipe page.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public static void switchToFeedback() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Feedback page.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public static void switchToDishes() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Dishes page.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}