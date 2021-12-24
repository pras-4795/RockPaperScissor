package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;


@Table(name = "scores")
@Entity
public class Score {

    @Id
    private String gameId;

    private int userScore;
    private int systemScore;

    public Score() {
    }

    public Score(String gameId, int userScore, int systemScore) {
        this.gameId = gameId;
        this.userScore = userScore;
        this.systemScore = systemScore;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Score score = (Score) o;
        return gameId.equals(score.gameId) && userScore == score.userScore && systemScore == score.systemScore;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, userScore, systemScore);
    }

    @Override
    public String toString() {
        return "Score{" +
                "gameId=" + gameId +
                ", userScore='" + userScore + '\'' +
                ", systemScore='" + systemScore + '\'' +
                '}';
    }
}
