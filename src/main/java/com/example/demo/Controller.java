package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;




public class Controller {
    private final int WIDTH = 900;
    private final int HEIGHT = 900;
    @FXML
    public Button start;
    @FXML
    public Button settings;
    @FXML
    public Button help;
    private static Stage stage;
    private Group gameRoot = new Group();
    private Group controlsRoot = new Group();
    GameScene game = new GameScene();

    public void StartButtonClicked(ActionEvent actionEvent) {
        Group endgameRoot = new Group();
        Scene endGameScene = new Scene(endgameRoot, WIDTH, HEIGHT, Color.rgb(250, 20, 100, 0.2));
        Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92));
        Scene controlsScene = new Scene(controlsRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92));
        stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(gameScene);
        game.game(gameScene, gameRoot, stage, endGameScene, endgameRoot);
        stage.show();
    }


}
