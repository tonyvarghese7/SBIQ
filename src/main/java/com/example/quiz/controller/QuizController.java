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
            @RequestParam(required = false) String answer11,
            @RequestParam(required = false) String answer12,
            @RequestParam(required = false) String answer13,
            @RequestParam(required = false) String answer14,
            @RequestParam(required = false) String answer15,
            @RequestParam(required = false) String answer16,
            @RequestParam(required = false) String answer17,
            @RequestParam(required = false) String answer18,
            @RequestParam(required = false) String answer19,
            @RequestParam(required = false) String answer20,
            @RequestParam(required = false) String answer21,
            @RequestParam(required = false) String answer22,
            @RequestParam(required = false) String answer23,
            @RequestParam(required = false) String answer24,
            @RequestParam(required = false) String answer25,
            @RequestParam(required = false) String answer26,
            @RequestParam(required = false) String answer27,
            @RequestParam(required = false) String answer28,
            @RequestParam(required = false) String answer29,
            @RequestParam(required = false) String answer30,
            HttpSession session,
            Model model) {

        // Retrieve questions from session first
        List<Question> questions = (List<Question>) session.getAttribute("currentQuizQuestions");

        if (questions == null) {
            return "redirect:/quiz";
        }

        // 🔐 Validation
        /*if (Stream.of(answer1, answer2, answer3, answer4, answer5,
                answer6, answer7, answer8, answer9, answer10,
                answer11, answer12, answer13, answer14, answer15,
                answer16, answer17, answer18, answer19, answer20,
                answer21, answer22, answer23, answer24, answer25,
                answer26, answer27, answer28, answer29, answer30)
                .anyMatch(a -> a == null || a.isBlank())) {

            model.addAttribute("error", "Please answer all questions before submitting.");
            model.addAttribute("questions", questions); // Add questions back to model
            model.addAttribute("allAttempted", false);
            return "quiz"; // stay on quiz page
        }*/

        String [] answers={answer1, answer2, answer3, answer4, answer5,
                answer6, answer7, answer8, answer9, answer10,
                answer11, answer12, answer13, answer14, answer15,
                answer16, answer17, answer18, answer19, answer20,
                answer21, answer22, answer23, answer24, answer25,
                answer26, answer27, answer28, answer29, answer30
        };

        for (int i=0 ;i<questions.size();i++)
            if(answers[i]==null||answers[i].isBlank()){
                model.addAttribute("error", "Please answer all questions before submitting.");
                model.addAttribute("questions", questions); // Add questions back to model
                model.addAttribute("allAttempted", false);
                return "quiz"; // stay on quiz page

            }

        UserQuiz uq = new UserQuiz();
        uq.setUserId((Long) session.getAttribute("userId"));

        // Map IDs from questions list to UserQuiz fields
        for (int i = 0; i < questions.size(); i++) {
            switch (i) {
                case 0 -> uq.setQ1Id(questions.get(i).getId());
                case 1 -> uq.setQ2Id(questions.get(i).getId());
                case 2 -> uq.setQ3Id(questions.get(i).getId());
                case 3 -> uq.setQ4Id(questions.get(i).getId());
                case 4 -> uq.setQ5Id(questions.get(i).getId());
                case 5 -> uq.setQ6Id(questions.get(i).getId());
                case 6 -> uq.setQ7Id(questions.get(i).getId());
                case 7 -> uq.setQ8Id(questions.get(i).getId());
                case 8 -> uq.setQ9Id(questions.get(i).getId());
                case 9 -> uq.setQ10Id(questions.get(i).getId());
                case 10 -> uq.setQ11Id(questions.get(i).getId());
                case 11 -> uq.setQ12Id(questions.get(i).getId());
                case 12 -> uq.setQ13Id(questions.get(i).getId());
                case 13 -> uq.setQ14Id(questions.get(i).getId());
                case 14 -> uq.setQ15Id(questions.get(i).getId());
                case 15 -> uq.setQ16Id(questions.get(i).getId());
                case 16 -> uq.setQ17Id(questions.get(i).getId());
                case 17 -> uq.setQ18Id(questions.get(i).getId());
                case 18 -> uq.setQ19Id(questions.get(i).getId());
                case 19 -> uq.setQ20Id(questions.get(i).getId());
                case 20 -> uq.setQ21Id(questions.get(i).getId());
                case 21 -> uq.setQ22Id(questions.get(i).getId());
                case 22 -> uq.setQ23Id(questions.get(i).getId());
                case 23 -> uq.setQ24Id(questions.get(i).getId());
                case 24 -> uq.setQ25Id(questions.get(i).getId());
                case 25 -> uq.setQ26Id(questions.get(i).getId());
                case 26 -> uq.setQ27Id(questions.get(i).getId());
                case 27 -> uq.setQ28Id(questions.get(i).getId());
                case 28 -> uq.setQ29Id(questions.get(i).getId());
                case 29 -> uq.setQ30Id(questions.get(i).getId());
            }
        }

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
        uq.setAnswer11(answer11);
        uq.setAnswer12(answer12);
        uq.setAnswer13(answer13);
        uq.setAnswer14(answer14);
        uq.setAnswer15(answer15);
        uq.setAnswer16(answer16);
        uq.setAnswer17(answer17);
        uq.setAnswer18(answer18);
        uq.setAnswer19(answer19);
        uq.setAnswer20(answer20);
        uq.setAnswer21(answer21);
        uq.setAnswer22(answer22);
        uq.setAnswer23(answer23);
        uq.setAnswer24(answer24);
        uq.setAnswer25(answer25);
        uq.setAnswer26(answer26);
        uq.setAnswer27(answer27);
        uq.setAnswer28(answer28);
        uq.setAnswer29(answer29);
        uq.setAnswer30(answer30);

        userQuizRepo.save(uq);

        // build result view
        List<QuizResultDTO> results = new ArrayList<>();

        for (int i = 0; i < questions.size(); i++) {
            Question q = questionRepo.findById(questions.get(i).getId()).orElseThrow();

            Map<String, String> options = new java.util.LinkedHashMap<>();
            options.put("A", q.getOption1());
            options.put("B", q.getOption2());
            options.put("C", q.getOption3());
            options.put("D", q.getOption4());

            results.add(new QuizResultDTO(
                    q.getQuestionText(),
                    q.getCorrectOption(),   // from DB
                    answers[i],             // user selection
                    options
            ));


        }

// Clear session after successful submission
        session.removeAttribute("currentQuizQuestions");
        model.addAttribute("results", results);

        return "quiz-submitted";

    }

}
