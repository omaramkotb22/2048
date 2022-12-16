package com.example.demo;

public class Player {
    public String getName() {
        return name;
    }

    private final String name;

    public Integer getHighscore() {
        return highscore;
    }

    private final Integer highscore;
    public Player(String name, Integer highscore) {
        this.name = name;
        this.highscore = highscore;
    }
}
