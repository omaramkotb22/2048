package com.example.demo.PlayersPackage;

public class Player {

    public String getName() {
        return name;
    }

    private final String name;

    public Integer getHighscore() {
        return highscore;
    }


    private final Integer highscore;

    /**
     *
     * @param name
     * @param highscore
     */
    public Player(String name, Integer highscore) {
        this.name = name;
        this.highscore = highscore;
    }
}
