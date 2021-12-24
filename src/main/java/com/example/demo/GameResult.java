package com.example.demo;

public class GameResult {
    private String serverMove;
    private int userScore;
    private int systemScore;

    public GameResult(String serverMove, int userScore, int systemScore) {
        this.serverMove = serverMove;
        this.userScore = userScore;
        this.systemScore = systemScore;
    }

    public String getServerMove() {
        return serverMove;
    }

    public void setServerMove(String serverMove) {
        this.serverMove = serverMove;
    }

    public int getUserScore() {
        return userScore;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    public int getSystemScore() {
        return systemScore;
    }

    public void setSystemScore(int systemScore) {
        this.systemScore = systemScore;
    }
}
