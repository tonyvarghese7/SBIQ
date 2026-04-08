package com.example.quiz.controller;

import com.example.quiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LeaderboardController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/leaderboard")
    public String showLeaderboard(Model model) {
        // Fetch top 10 scores
        model.addAttribute("topUsers", userRepository.findTop10ByOrderByScoreDesc());
        return "leaderboard";
    }
}
