package com.example.demo;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

public class LeaderboardScene {

    void leaderboard(Group root, Stage stage) throws IOException {
        var players = new ReadPlayers("src/main/resources/com/example/demo/players.csv");
//        HashMap<String, Integer> players = new HashMap<String, Integer>();

        var playersMap = players.getMap();
        VBox textBox = new VBox();
        for(Map.Entry<String, Integer> player:playersMap.entrySet()){
            Text text = new Text();
            LeaderboardStyles.PlayersName(text);
            text.setText(player.getValue() + player.getKey());
            textBox.getChildren().add(text);
        }
        textBox.setAlignment(Pos.CENTER);
        root.getChildren().add(textBox);
        Scene scene = new Scene(root,600,600);
        stage.setScene(scene);
    }
    private void addPlayer(String name, int score){

    }



}
