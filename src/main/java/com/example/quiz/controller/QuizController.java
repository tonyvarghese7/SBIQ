package com.example.quiz.controller;

import com.example.quiz.entity.Question;
import com.example.quiz.entity.UserQuiz;
import com.example.quiz.repository.QuestionRepository;
import com.example.quiz.repository.UserQuizRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Controller
public class QuizController {

    @Autowired
    private QuestionRepository questionRepo;

    @Autowired
    private UserQuizRepository userQuizRepo;

    // ===== Show quiz page =====
    @GetMapping("/quiz")
    public String showQuiz(HttpSession session, Model model) {

        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) return "redirect:/";

        // 1️⃣ Fetch fresh unattempted questions (limit 10)
        List<Question> fresh = questionRepo.findFreshQuestionsForUser(userId);

        // 2️⃣ If no questions left → show message
        if (fresh.isEmpty()) {
            model.addAttribute("allAttempted", true);
            return "quiz";
        }

        // 3️⃣ Create new quiz attempt ONLY if questions exist
        UserQuiz uq = new UserQuiz();
        uq.setUserId(userId);
        uq = userQuizRepo.save(uq);

        // 4️⃣ Assign question IDs
        for (int i = 0; i < fresh.size(); i++) {
            switch (i) {
                case 0 -> uq.setQ1Id(fresh.get(i).getId());
                case 1 -> uq.setQ2Id(fresh.get(i).getId());
                case 2 -> uq.setQ3Id(fresh.get(i).getId());
                case 3 -> uq.setQ4Id(fresh.get(i).getId());
                case 4 -> uq.setQ5Id(fresh.get(i).getId());
                case 5 -> uq.setQ6Id(fresh.get(i).getId());
                case 6 -> uq.setQ7Id(fresh.get(i).getId());
                case 7 -> uq.setQ8Id(fresh.get(i).getId());
                case 8 -> uq.setQ9Id(fresh.get(i).getId());
                case 9 -> uq.setQ10Id(fresh.get(i).getId());
            }
        }

        userQuizRepo.save(uq);

        model.addAttribute("questions", fresh);
        model.addAttribute("allAttempted", false);
        session.setAttribute("userQuizId", uq.getId());

        return "quiz";
    }
    @PostMapping("/submit-quiz")
    public String submitQuiz(
            @RequestParam(required = false) String answer1,
            @RequestParam(required = false) String answer2,
            @RequestParam(required = false) String answer3,
            @RequestParam(required = false) String answer4,
            @RequestParam(required = false) String answer5,
            @RequestParam(required = false) String answer6,
            @RequestParam(required = false) String answer7,
            @RequestParam(required = false) String answer8,
            @RequestParam(required = false) String answer9,
            @RequestParam(required = false) String answer10,
            HttpSession session,
            Model model) {

        // 🔐 Validation
        if (Stream.of(answer1, answer2, answer3, answer4, answer5,
                        answer6, answer7, answer8, answer9, answer10)
                .anyMatch(a -> a == null || a.isBlank())) {

            model.addAttribute("error", "Please answer all questions before submitting.");
            return "quiz"; // stay on quiz page
        }

        Long quizAttemptId = (Long) session.getAttribute("userQuizId");
        if (quizAttemptId == null) return "redirect:/";

        UserQuiz uq = userQuizRepo.findById(quizAttemptId)
                .orElseThrow(() -> new IllegalStateException("Quiz attempt not found"));

        uq.setAnswer1(answer1);
        uq.setAnswer2(answer2);
        uq.setAnswer3(answer3);
        uq.setAnswer4(answer4);
        uq.setAnswer5(answer5);
        uq.setAnswer6(answer6);
        uq.setAnswer7(answer7);
        uq.setAnswer8(answer8);
        uq.setAnswer9(answer9);
        uq.setAnswer10(answer10);

        userQuizRepo.save(uq);

        return "quiz-submitted";
    }


}
