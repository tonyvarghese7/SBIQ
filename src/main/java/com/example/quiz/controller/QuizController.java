package com.example.quiz.controller;

import com.example.quiz.dto.QuizResultDTO;
import com.example.quiz.entity.Question;
import com.example.quiz.entity.UserQuiz;
import com.example.quiz.repository.QuestionRepository;
import com.example.quiz.repository.UserQuizRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class QuizController {

    @Autowired
    private QuestionRepository questionRepo;

    @Autowired
    private UserQuizRepository userQuizRepo;

    @Autowired
    private com.example.quiz.repository.UserRepository userRepo;

    // ===== Show quiz page =====
    @GetMapping("/quiz")
    public String showQuiz(HttpSession session, Model model) {

        Long userId = (Long) session.getAttribute("userId");
        if (userId == null)
            return "redirect:/";

        // 1️⃣ Check if we have an ongoing quiz in session
        List<Question> currentQuestions = (List<Question>) session.getAttribute("currentQuizQuestions");

        if (currentQuestions == null) {
            // 2️⃣ Fetch fresh unattempted questions (limit 30)
            currentQuestions = questionRepo.findFreshQuestionsForUser(userId);

            // 3️⃣ If no questions left → show message
            if (currentQuestions.isEmpty()) {
                model.addAttribute("allAttempted", true);
                return "quiz";
            }

            // 4️⃣ Store in session (do NOT save to DB yet)
            session.setAttribute("currentQuizQuestions", currentQuestions);
        }

        model.addAttribute("questions", currentQuestions);
        model.addAttribute("allAttempted", false);

        return "quiz";
    }

    @PostMapping("/submit-quiz")
    public String submitQuiz(@RequestParam Map<String, String> allParams,
            HttpSession session,
            Model model) {

        Long userId = (Long) session.getAttribute("userId");
        if (userId == null)
            return "redirect:/";

        List<Question> questions = (List<Question>) session.getAttribute("currentQuizQuestions");
        if (questions == null)
            return "redirect:/quiz";

        // Validate all answers present
        for (int i = 0; i < questions.size(); i++) {
            String ans = allParams.get("answer" + (i + 1));
            if (ans == null || ans.isBlank()) {
                model.addAttribute("error", "Please answer all questions before submitting.");
                model.addAttribute("questions", questions);
                model.addAttribute("allAttempted", false);
                return "quiz";
            }
        }

        int score = 0;
        List<QuizResultDTO> results = new ArrayList<>();

        // Process each question
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            String ans = allParams.get("answer" + (i + 1));

            // 1. Save individual answer to UserQuiz table
            // userQuizId here is mapped to the Question ID as per user request
            UserQuiz uq = new UserQuiz(userId, q.getId(), ans);
            userQuizRepo.save(uq);

            // 2. Calculate Score
            boolean isCorrect = ans.equals(q.getCorrectOption());
            if (isCorrect) {
                score++;
            }

            // 3. Build Result DTO
            Map<String, String> options = new java.util.LinkedHashMap<>();
            options.put("A", q.getOption1());
            options.put("B", q.getOption2());
            options.put("C", q.getOption3());
            options.put("D", q.getOption4());

            results.add(new QuizResultDTO(
                    q.getQuestionText(),
                    q.getCorrectOption(),
                    ans,
                    options));
        }

        // 4. Update User Score in DB
        com.example.quiz.entity.User user = userRepo.findById(userId).orElseThrow();
        user.setScore(user.getScore() + score);
        userRepo.save(user);

        // Clear session and show results
        session.removeAttribute("currentQuizQuestions");
        model.addAttribute("results", results);
        model.addAttribute("score", score);
        model.addAttribute("totalQuestions", questions.size());

        return "quiz-submitted";
    }

}
