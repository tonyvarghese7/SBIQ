package com.example.quiz.controller;

import com.example.quiz.entity.User;
import com.example.quiz.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/email")
    public String emailPage() {
        return "email";
    }

    @PostMapping("/start-quiz")
    public String startQuiz(@RequestParam String email, HttpSession session) {

        User user = userRepository.findByEmail(email)
                .orElseGet(() -> {
                    User newUser = new User();
                    newUser.setEmail(email);
                    return userRepository.save(newUser);
                });

        session.setAttribute("userId", user.getId());

        return "redirect:/quiz";
    }
}

