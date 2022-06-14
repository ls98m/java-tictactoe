package com.daw.prog;

public class Player {

    private String name;

    private char token;

    private int score;


    Player(String name, char token) {

        this.name = name;
        this.token = token;
        this.score = 0;

    }

    public String getName() {

        return name;

    }

    public char getToken() {

        return token;

    }

    public int getScore() {

        return score;

    }

    public void setScore(int score) {

        this.score += score;

    }

}