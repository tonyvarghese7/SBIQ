package com.example.quiz.repository;

import com.example.quiz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    
    // Fetch top 10 users ordered by score descending for the leaderboard
    java.util.List<User> findTop10ByOrderByScoreDesc();
}
