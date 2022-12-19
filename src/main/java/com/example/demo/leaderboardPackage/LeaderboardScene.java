package com.example.demo.leaderboardPackage;

import com.example.demo.Controller;
import com.example.demo.PlayersPackage.Player;
import com.example.demo.PlayersPackage.ReadPlayers;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Comparator;

public class LeaderboardScene {
    private static LeaderboardScene single_instance = null;

    public LeaderboardScene() {
    }

    /**
     *
     * @param root
     * @param stage
     * @throws IOException
     */
    public void leaderboard(Group root, Stage stage) throws IOException {
        var players = new ReadPlayers("src/main/resources/com/example/demo/players.csv");
        var playersList = players.getPlayerList();
        playersList.sort(Comparator.comparing(Player::getHighscore).reversed());
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
        VBox nameList = new VBox();
        VBox ranksList = new VBox();
        VBox highscoreList = new VBox();
        int counter = 0;
        for(Player player: playersList){
            counter+=1;
            Text rank = new Text();
            rank.setText(String.valueOf(counter));
            LeaderboardStyles.PlayersRank(rank);
            ranksList.getChildren().add(rank);
            Text name = new Text();
            name.setText(player.getName());
            LeaderboardStyles.PlayersName(name);
            nameList.getChildren().add(name);
            Text score = new Text();
            score.setText(String.valueOf(player.getHighscore()));
            LeaderboardStyles.PlayersHighscore(score);
            highscoreList.getChildren().add(score);
        }
        highscoreList.setAlignment(Pos.BOTTOM_RIGHT);
        ranksList.relocate(90,100);
        nameList.relocate(120,100);
        highscoreList.relocate(200, 100);


        Scene scene = new Scene(root,600,600);
        root.getChildren().addAll(nameList, ranksList,highscoreList);
        stage.setScene(scene);

    }

    public static LeaderboardScene getInstance(){
        if(single_instance == null){
            single_instance = new LeaderboardScene();
        }
        return single_instance;
    }
}
