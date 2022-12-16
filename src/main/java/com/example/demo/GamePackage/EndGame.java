package com.example.demo.GamePackage;

import com.example.demo.Controller;
import com.example.demo.PlayersPackage.Player;
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
import java.util.LinkedList;


public class EndGame {
    public Scene getEndGameScene() {
        return endGameScene;
    }

    private Scene endGameScene;
    private GameScene gameScene;
    private static EndGame singleInstance = null;

    public EndGame(GameScene gameScene) throws IOException {
        this.gameScene = gameScene;
    }
    public static EndGame getInstance(GameScene gameScene) throws IOException {
        if(singleInstance == null)
            singleInstance = new EndGame(gameScene);
        return singleInstance;
    }

    public void endGameShow(Group root, Stage primaryStage, long score, String name) throws IOException {
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
        Integer currentHighscore = 0;
        LinkedList<Player> playerList = gameScene.getPlayerList();
        for (Player player : playerList) {
            if(player.getName().equals(name)){
                currentHighscore = player.getHighscore();
            }
        }

        if(score > (long) currentHighscore){
            scoreText.setText("Game Over\nNew Highscore! " + score);
            playerList.add(new Player(name, (int) score));
        }
        else {
            currentHighscore = Math.toIntExact(score);
            scoreText.setText("Game Over\n" + score + "\nHighscore still" + currentHighscore);
        }

        GameSceneStyles.ScoreText(scoreText);
        vBox.getChildren().addAll(scoreText,restartButton, mainMenuButton,quitGameBtn);
        vBox.relocate(0,0);
        vBox.setAlignment(Pos.CENTER);
        Scene endGameScene = new Scene(vBox, 300, 250);
        popup.setScene(endGameScene);
        popup.show();
    }
}