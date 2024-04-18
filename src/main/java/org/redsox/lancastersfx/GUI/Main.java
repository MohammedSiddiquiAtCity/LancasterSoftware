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

/**
 * The main class for the LancasterSoftware GUI application.
 */

public class Main extends Application {
    private static Stage stage;
    private static BorderPane root;
    public Kitchen kitchen = new Kitchen();


    /**
     * Starts the JavaFX application by initializing the main stage and displaying the main scene.
     *
     * @param stage The primary stage for the application.
     * @throws IOException If an error occurs while loading the main scene.
     */
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        this.stage.setTitle("LancasterSoftware");
        showMain();
    }

    /**
     * Displays the main scene of the application.
     *
     * @throws IOException If an error occurs while loading the main scene.
     */
    public void showMain() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Main.class.getResource("LoginPage.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();

    }

    /**
     * Switches to the login page.
     *
     * @throws IOException If an error occurs while loading the login page.
     */
    public static void switchToLogin() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LoginPage.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Switches to the inventory page.
     *
     * @throws IOException If an error occurs while loading the inventory page.
     */
    public static void switchToInventory() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Inventory page.fxml"));
        BorderPane borderPane = fxmlLoader.load();
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Switches to the menu selection page.
     *
     * @throws IOException If an error occurs while loading the menu selection page.
     */
    public static void switchToMenuSelection() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Menu page.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Switches to the orders page.
     *
     * @throws IOException If an error occurs while loading the orders page.
     */
    public static void switchToOrders() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Orders page.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Switches to the recipes page.
     *
     * @throws IOException If an error occurs while loading the recipes page.
     */
    public static void switchToRecipes() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Recipe page.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Switches to the feedback page.
     *
     * @throws IOException If an error occurs while loading the feedback page.
     */
    public static void switchToFeedback() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Feedback page.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Switches to the dishes page.
     *
     * @throws IOException If an error occurs while loading the dishes page.
     */
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