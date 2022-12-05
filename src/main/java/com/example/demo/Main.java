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
    static final int WIDTH = 900; // Setting the Width of the Window to 900
    static final int HEIGHT = 900; // Setting the Length of the Window to 900

    private Group gameRoot = new Group();// This is the root for the other game groups

    private Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92));


    private static Scanner input = new Scanner(System.in); // New object of Class Scanner to retrieve input from user



    public void setGameScene(Scene gameScene) { // sets the scene that will be used during gameplay
        this.gameScene = gameScene;
    }

    public void setGameRoot(Group gameRoot) { // sets game root
        this.gameRoot = gameRoot;
    }


    /*
    * @param primaryStage
    * */

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group menuRoot = new Group(); // this group will be the root of all the other menu groups that will be created
//        Scene menuScene = new Scene(menuRoot, WIDTH, HEIGHT); // This creates the menu scene that will later be used to generate the menu
        Group accountRoot = new Group(); // The account root has no children
        Scene accountScene = new Scene(accountRoot, WIDTH, HEIGHT, Color.rgb(150, 20, 100, 0.2)); // This creates the account scenes that will later be used to generate the accounts
        Group getAccountRoot = new Group();
//        Scene getAccountScene = new Scene(getAccountRoot, WIDTH, HEIGHT, Color.rgb(200, 20, 100, 0.2));
        Group endgameRoot = new Group(); // The root of the scene that ends the game, does not have children but has parents in
//        Scene endGameScene = new Scene(endgameRoot, WIDTH, HEIGHT, Color.rgb(250, 20, 100, 0.2));
        Group rankRoot = new Group();
//        Scene rankScene = new Scene(rankRoot, WIDTH, HEIGHT, Color.rgb(250, 50, 120, 0.3));
        BackgroundFill background_fill = new BackgroundFill(Color.rgb(120, 100, 100), CornerRadii.EMPTY, Insets.EMPTY);
//        Background background = new Background(background_fill);

        // Menu Background designing
        Rectangle backgroundOfMenu = new Rectangle(240, 120, Color.rgb(120, 120, 120, 0.2));
        backgroundOfMenu.setX(WIDTH / 2 - 120);
        backgroundOfMenu.setY(180);
        menuRoot.getChildren().add(backgroundOfMenu);
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainMenuLight.fxml")));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
