package com.example.quiz.dto;

import java.util.Map;

public class QuizResultDTO {

    private String question;
    private String correctOption;
    private String userOption;
    private Map<String, String> options;

    public QuizResultDTO(String question,
                         String correctOption,
                         String userOption,
                         Map<String, String> options) {
        this.question = question;
        this.correctOption = correctOption;
        this.userOption = userOption;
        this.options = options;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectOption() {
        return correctOption;
    }

    public String getUserOption() {
        return userOption;
    }

    public Map<String, String> getOptions() {
        return options;
    }
}