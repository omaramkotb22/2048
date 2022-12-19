package com.example.demo.GamePackage;

import com.example.demo.Controller;
import com.example.demo.PlayersPackage.Player;
import com.example.demo.PlayersPackage.WritePlayers;
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

/**
 * Creates a new instance of the EndGame class.
 *
 * @throws IOException if there is an error reading from the players file.
 */

public class EndGame {
    private final GameScene gameScene;
    private static EndGame singleInstance = null;

    public EndGame(GameScene gameScene) throws IOException {
        this.gameScene = gameScene;
    }

    /**
     * Returns the single instance of the EndGame class. If no instance has been created, a new one is created.
     *
     * @param gameScene the current GameScene object.
     * @return the single instance of the EndGame class.
     * @throws IOException if there is an error reading from the players file.
     */
    public static EndGame getInstance(GameScene gameScene) throws IOException {
        if(singleInstance == null)
            singleInstance = new EndGame(gameScene);
        return singleInstance;
    }
    /**
     The endGameShow method is responsible for displaying the "Game Over" screen and handling the player's actions on this screen.
     It creates a new Stage object for the "Game Over" screen and sets up the scene with buttons for the player to choose from.
     It also shows the player's score and checks if it is a new high score. If it is, it updates the player's high score and
     writes the updated player information to the player list file.
     @param primaryStage The primary Stage object being used in the application.
     @param score The player's score at the end of the game.
     @param name The name of the player.
     @throws IOException Thrown if there is an issue reading or writing to the player list file.
     */
    public void endGameShow(Stage primaryStage, long score, String name) throws IOException {
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
            Player player = new Player(name, (int) score);
            playerList.add(player);
            WritePlayers.AddPlayers(player);
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