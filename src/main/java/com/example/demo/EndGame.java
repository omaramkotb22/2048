package com.example.demo;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;


public class EndGame {
    public Scene getEndGameScene() {
        return endGameScene;
    }

    private Scene endGameScene;
    private static EndGame singleInstance = null;

    private EndGame() throws IOException {

    }
    public static EndGame getInstance() throws IOException {
        if(singleInstance == null)
            singleInstance = new EndGame();
        return singleInstance;
    }
    private ReadPlayers map = new ReadPlayers("src/main/resources/com/example/demo/players.csv");

    public void endGameShow(Group root, Stage primaryStage, long score, String name) throws IOException {

        var currentHighScore = map.getMap().getOrDefault(name, 0);
        Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        VBox vBox = new VBox();
        vBox.setSpacing(10);
        Button restartButton = new Button();
        GameSceneStyles.Button(restartButton, "Restart Game");
        Button quitGameBtn = new Button();
        GameSceneStyles.Button(quitGameBtn, "Quit Game");
        Button mainMenuButton = new Button();
        GameSceneStyles.Button(mainMenuButton, "Main Menu");
        mainMenuButton.setFocusTraversable(false);
        mainMenuButton.setOnAction(e-> {
            try {
                new Controller().SwitchToMenu(e);
                primaryStage.close();

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        restartButton.setOnAction(e->{
            try {
                new Controller().StartGameScene(e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        });
        Text scoreText = new Text();
        if(score > currentHighScore){
            scoreText.setText("Game Over\nNew Highscore! " + score);
        }
        else{
            currentHighScore = Math.toIntExact(score);
            scoreText.setText("Game Over\n" + score + "\nHighscore still" + currentHighScore);
        }

        map.getMap().put(name, (int) score);

        WritePlayers.addPlayer(name, (int)score);
        GameSceneStyles.ScoreText(scoreText);
        vBox.getChildren().addAll(scoreText,restartButton, mainMenuButton,quitGameBtn);
        vBox.relocate(0,0);
        vBox.setAlignment(Pos.CENTER);
        Scene endGameScene = new Scene(vBox, 300, 250);
        popup.setScene(endGameScene);
        popup.show();
    }
}