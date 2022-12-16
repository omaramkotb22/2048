package com.example.demo;

import java.io.*;

public class WritePlayers {
    private static final String FILE_PATH = "src/main/resources/com/example/demo/players.csv";

    public static void AddPlayers(String guestName, int highscore) throws IOException {
        Writer writer;
        writer = new BufferedWriter(new FileWriter(FILE_PATH, true));
        String newUser = (guestName + "," + highscore + "\n");
        writer.append(newUser);
        writer.close();
    }
    public static void DeleteAllLines() throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(FILE_PATH);
        printWriter.print("");
        printWriter.close();

    }

}
