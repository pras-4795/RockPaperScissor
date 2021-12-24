package com.example.demo.web;

import com.example.demo.GameResult;
import com.example.demo.model.Score;
import com.example.demo.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    @Autowired
    GameService gameService;

    @GetMapping("/start")
    public String initializeGame() {
        return gameService.initializeGame();
    }

    @GetMapping("/v1/{token}/{userMove}")
    public ResponseEntity<GameResult> processUserMove(@PathVariable String token, @PathVariable String userMove) {
        return ResponseEntity.ok(gameService.processUserMove(token, userMove.toLowerCase()));
    }

    @GetMapping("/v2/{token}/{userMove}")
    public ResponseEntity<GameResult> processUserMoveV2(@PathVariable String token, @PathVariable String userMove) {
        return ResponseEntity.ok(gameService.processUserMoveV2(token, userMove.toLowerCase()));
    }
}
