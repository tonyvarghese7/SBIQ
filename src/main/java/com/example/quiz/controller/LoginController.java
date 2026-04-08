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
    public String loginOrRegister(@RequestParam String email, @RequestParam String password, HttpSession session,
            org.springframework.ui.Model model) {

        // Global password validation criteria
        boolean hasLength = password.length() >= 8;
        boolean hasUpper = password.matches(".*[A-Z].*");
        boolean hasNumber = password.matches(".*[0-9].*");
        boolean hasSpecial = password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");

        if (!hasLength || !hasUpper || !hasNumber || !hasSpecial) {
            model.addAttribute("error", "Password must meet all complexity requirements.");
            return "login";
        }

        java.util.Optional<User> existingUser = userRepository.findByEmail(email);

        User user;
        if (existingUser.isPresent()) {
            user = existingUser.get();
            // Simple string comparison for now (in production use BCrypt)
            if (!user.getPassword().equals(password)) {
                model.addAttribute("error", "Invalid password for existing email.");
                return "login";
            }
        } else {
            user = new User();
            user.setEmail(email);
            user.setPassword(password);
            userRepository.save(user);
        }

        // store user id in session for later use
        session.removeAttribute("currentQuizQuestions");
        session.setAttribute("userId", user.getId());

        return "redirect:/select-level";
    }

    @GetMapping("/success")
    public String success() {
        return "success";
    }
}
