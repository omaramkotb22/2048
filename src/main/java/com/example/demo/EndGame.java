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


public class EndGame {
    public Scene getEndGameScene() {
        return endGameScene;
    }

    private Scene endGameScene;
    private static EndGame singleInstance = null;

    private EndGame(){

    }
    public static EndGame getInstance(){
        if(singleInstance == null)
            singleInstance = new EndGame();
        return singleInstance;
    }

    public void endGameShow(Group root, Stage primaryStage, long score){
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
        mainMenuButton.setOnAction(e-> {
            try {
                ((Stage) root.getScene().getWindow()).close();
                new Controller().SwitchToMenu(e);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        restartButton.setOnAction(e->new Controller().StartGameScene(e));
        Text scoreText = new Text("Game Over \n Score: " + score);
        GameSceneStyles.ScoreText(scoreText);
        vBox.getChildren().addAll(scoreText,restartButton,quitGameBtn, mainMenuButton);
        vBox.relocate(0,0);
        vBox.setAlignment(Pos.CENTER);
        Scene endGameScene = new Scene(vBox, 300, 250);
        popup.setScene(endGameScene);
        popup.showAndWait();
    }
}
