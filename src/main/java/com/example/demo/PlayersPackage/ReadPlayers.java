package com.example.demo.PlayersPackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class ReadPlayers {
    public LinkedList<Player> getPlayerList() {
        return PlayerList;
    }

    public void setPlayerList(LinkedList<Player> playerList) {
        PlayerList = playerList;
    }

    LinkedList<Player> PlayerList = new LinkedList<Player>();


    private Integer highscore;




    public ReadPlayers(String filename) throws IOException {
        readCSV(filename);
    }

    private void readCSV(String filename) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        String line = null;
        while((line=bufferedReader.readLine()) != null){
            String[] str = line.split(",");
            PlayerList.add(new Player(str[0], Integer.valueOf(str[1])));
        }
    }


}

