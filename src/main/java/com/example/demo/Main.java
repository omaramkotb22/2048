package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;

import java.util.Objects;
import java.util.Scanner;
    /*
    * Main class creates the window that the game will be played on
    * This includes the All the Groups and the scenes associated to them
    */

public class Main extends Application { // Inheriting the Application class from Java fx to start designing the Window
    static final int WIDTH = 900;
    static final int HEIGHT = 900;

    private Group gameRoot = new Group();// This is the root for the other game groups

//    private Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92));


    private static Scanner input = new Scanner(System.in); // New object of Class Scanner to retrieve input from user





    public void setGameRoot(Group gameRoot) { // sets game root
        this.gameRoot = gameRoot;
    }


    /*
    * @param primaryStage
    * */

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainMenuLight.fxml")));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
