package com.example.demo.PlayersPackage;

import java.io.*;

public class WritePlayers {
    public WritePlayers(String filename){

    }
    private static final String FILE_PATH = "src/main/resources/com/example/demo/players.csv";

    public static void AddPlayers(Player player) throws IOException {

        Writer writer;
        writer = new BufferedWriter(new FileWriter(FILE_PATH, true));
        String newUser = (player.getName() + "," + player.getHighscore() + "\n");
        writer.append(newUser);
        writer.close();
    }


}
