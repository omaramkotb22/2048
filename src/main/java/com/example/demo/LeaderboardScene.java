package com.example.demo;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;

public class LeaderboardScene {

    void leaderboard(Group root, Stage stage) throws IOException {
        var players = new ReadPlayers("src/main/resources/com/example/demo/players.csv");

        var playersList = players.getPlayerList();
        Button button = new Button("Back");
        button.relocate(5,5);
        button.setOnAction(e->{
            try {
                new Controller().SwitchToMenu(e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        root.getChildren().add(button);
        VBox textBox = new VBox();
        int counter = 0;
        for(Player player: playersList){
            counter+=1;
            Text text = new Text();
            LeaderboardStyles.PlayersName(text);
            text.setText(counter + "\t" + player.getName() + "\t" + player.getHighscore());
            textBox.getChildren().add(text);
        }
        textBox.setAlignment(Pos.CENTER);
        textBox.relocate(100,100);

        Scene scene = new Scene(root,600,600);
        root.getChildren().add(textBox);
        stage.setScene(scene);

    }



}
