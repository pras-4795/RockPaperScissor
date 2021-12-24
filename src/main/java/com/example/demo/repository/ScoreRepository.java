package com.example.demo.repository;

import com.example.demo.model.Score;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends CrudRepository<Score, Integer> {
    Score findByGameId(String id);
}
