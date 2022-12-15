package com.example.demo;

import java.io.*;

public class WritePlayers {

    public static void addPlayer(String guestName, int highscore) throws IOException {
        Writer writer;
        writer = new BufferedWriter(new FileWriter("src/main/resources/com/example/demo/players.csv", true));

        String newUser = (guestName + "," + highscore + "\n");
        writer.append(newUser);
        writer.close();
    }

}
