package com.example.demo;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class GameSceneStyles {
    static void ScoreText(Text text){
        text.setFont(Font.font(30));
        text.setFill(Color.rgb(35,191,223));

    }
    static void Button(Button button, String text){
        button.setText(text);
        button.setTextFill(Color.rgb(35,191,223));
        button.setStyle("-fx-background-color: #ffffff;" + "-fx-font-weight: bold;" + "-fx-font-size: 20 px");

    }

}
