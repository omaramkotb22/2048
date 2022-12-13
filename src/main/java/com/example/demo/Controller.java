package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;


public class Controller {
    @FXML
    public Button settings;
    @FXML
    public Button help;
    private static Stage stage;
    private final Group gameRoot = new Group();
    private static Scene scene;
    private final Group controlsRoot = new Group();
    GameScene game = new GameScene();


    public void StartGameScene(ActionEvent actionEvent) {
        Group endgameRoot = new Group();
        int HEIGHT = 600;
        int WIDTH = 600;
        Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(200,200,200));
        Scene endGameScene = new Scene(endgameRoot, 200, 150, Color.rgb(200,200,200));
//        Scene controlsScene = new Scene(controlsRoot, WIDTH, HEIGHT, Color.rgb(255,255,255));
        stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(gameScene);
        game.game(gameScene, gameRoot, stage, endGameScene, endgameRoot);
        stage.show();
    }
    public void SwitchToMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainMenuLight.fxml")));
        Scene MenuScene = new Scene(root);
        Stage MenuStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        MenuStage.setScene(MenuScene);
        MenuStage.show();
    }
    public void SwitchToSettings(ActionEvent actionevent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SettingsLightTheme.fxml")));
        Scene SettingsScene = new Scene(root);
        stage = (Stage)((Node) actionevent.getSource()).getScene().getWindow();
        stage.setScene(SettingsScene);
        stage.show();
    }
    public void SwitchToLeaderboard(ActionEvent actionEvent) throws IOException{
        stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        new Leaderboard().leaderboard(gameRoot, stage);
        stage.show();
    }
}