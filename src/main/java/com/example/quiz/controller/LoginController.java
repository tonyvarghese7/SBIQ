package com.example.quiz.controller;

import com.example.quiz.entity.User;
import com.example.quiz.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String showEmailPage() {
        return "login";
    }

    @PostMapping("/login")
    public String saveUser(@RequestParam String email, HttpSession session) {

        User user = userRepository.findByEmail(email)
                .orElseGet(() -> {
                    User u = new User();
                    u.setEmail(email);
                    return userRepository.save(u);
                });

        // store user id in session for later use
        session.setAttribute("userId", user.getId());

        return "redirect:/quiz";
    }

    @GetMapping("/success")
    public String success() {
        return "success";
    }
}
