package com.example.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;

public class ReadPlayers{
    public HashMap<String, Integer> getMap() {
        return map;
    }

    HashMap<String, Integer> map = new HashMap<String,Integer>();


    public ReadPlayers(String filename) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        String line = null;
        while((line=bufferedReader.readLine()) != null){
            String[] str = line.split(",");
            map.put(str[0],Integer.valueOf(str[1]));
        }

    }
}

