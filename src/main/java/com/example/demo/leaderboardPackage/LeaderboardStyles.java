package com.example.demo.leaderboardPackage;

import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class LeaderboardStyles {
    /**
     *
     * @param text
     */
    public static void PlayersRank(Text text){
        text.setTextAlignment(TextAlignment.LEFT);
        text.setStyle("-fx-font-weight: bold; -fx-font-size: 15px;");
        text.setFill(Color.rgb(35,191,223));
    }
    public static void PlayersName(Text text){
        text.setTextAlignment(TextAlignment.LEFT);
        text.setStyle("-fx-font-weight: bold; -fx-font-size: 15px;");
        text.setFill(Color.rgb(35,191,223));
    }
    public static void PlayersHighscore(Text text){
        text.setTextAlignment(TextAlignment.RIGHT);
        text.setStyle("-fx-font-weight: bold; -fx-font-size: 15px");
        text.setFill(Color.rgb(35,191,223));
    }
}
