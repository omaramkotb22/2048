package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;
/**
 * Main class creates the window that the game will be played on
 * This includes the All the Groups and the scenes associated to them
 */

public class Main extends Application { // Inheriting the Application class from Java fx to start designing the Window
    /**
     * This method is called to start the application.
     * @param primaryStage the primary stage for this application.
     * @throws Exception if an error occurs while loading the FXML file.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainMenuLight.fxml")));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    /**
     * The main method is the entry point for the application.
     * @param args command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        launch(args);
    }
}