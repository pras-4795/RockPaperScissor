package com.example.demo.service;

import com.example.demo.GameResult;
import com.example.demo.model.Score;
import com.example.demo.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class GameService {

    @Autowired
    ScoreRepository scoreRepository;

    @Transactional
    public String initializeGame() {
        int leftLimit = 48;
        int rightLimit = 122;
        int targetStringLength = 20;
        Random random = new Random();

        String gameId = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        scoreRepository.save(new Score(gameId, 0, 0));
        return gameId;
    }

    @Transactional
    public GameResult processUserMove(String gameId, String userMove) {
        Score score = scoreRepository.findByGameId(gameId);

        if (score != null) {
            List<String> list = Arrays.asList("Rock", "Paper", "Scissors");

            Random rand = new Random();
            String randomMove = list.get(rand.nextInt(list.size()));

            Score updatedScore = calculateScore(score, userMove, randomMove.toLowerCase());

            if (updatedScore.getUserScore() == 3 || updatedScore.getSystemScore() == 3) {
                scoreRepository.delete(updatedScore);
            }
            return new GameResult(randomMove, updatedScore.getUserScore(), updatedScore.getSystemScore());
        }

        return null;
    }

    @Transactional
    public GameResult processUserMoveV2(String gameId, String userMove) {
        Score score = scoreRepository.findByGameId(gameId);

        if (score != null) {
            Score updatedScore = calculateScore(score, userMove, "Paper".toLowerCase());

            if (updatedScore.getSystemScore() >= 1) {
                scoreRepository.delete(updatedScore);
            }
            return new GameResult("Paper", updatedScore.getUserScore(), updatedScore.getSystemScore());
        }

        return null;
    }

    public Score calculateScore(Score score, String userMove, String systemMove) {
        if (systemMove.equals(userMove)) {
            return score;
        }
        switch (userMove) {
            case "rock":
                if (systemMove.equals("scissors")) {
                    score.setUserScore(score.getUserScore() + 1);
                } else {
                    score.setSystemScore(score.getSystemScore() + 1);
                }
                break;
            case "paper":
                if (systemMove.equals("rock")) {
                    score.setUserScore(score.getUserScore() + 1);
                } else {
                    score.setSystemScore(score.getSystemScore() + 1);
                }
                break;
            case "scissors":
                if (systemMove.equals("paper")) {
                    score.setUserScore(score.getUserScore() + 1);
                } else {
                    score.setSystemScore(score.getSystemScore() + 1);
                }
                break;
        }
        return score;
    }
}
