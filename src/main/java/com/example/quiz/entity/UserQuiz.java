package com.example.quiz.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_quiz")
public class UserQuiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // primary key for each attempt



    @Column(name = "user_id")
    private Long userId; // One row per user


    @Column(name = "q1_id")
    private Long q1Id;

    @Column(name = "q2_id")
    private Long q2Id;

    @Column(name = "q3_id")
    private Long q3Id;

    @Column(name = "q4_id")
    private Long q4Id;

    @Column(name = "q5_id")
    private Long q5Id;

    @Column(name = "q6_id")
    private Long q6Id;

    @Column(name = "q7_id")
    private Long q7Id;

    @Column(name = "q8_id")
    private Long q8Id;

    @Column(name = "q9_id")
    private Long q9Id;

    @Column(name = "q10_id")
    private Long q10Id;


    // ===== Answer columns =====
    @Column(name = "answer1")
    private String answer1;
    @Column(name = "answer2")
    private String answer2;
    @Column(name = "answer3")
    private String answer3;
    @Column(name = "answer4")
    private String answer4;
    @Column(name = "answer5")
    private String answer5;
    @Column(name = "answer6")
    private String answer6;
    @Column(name = "answer7")
    private String answer7;
    @Column(name = "answer8")
    private String answer8;
    @Column(name = "answer9")
    private String answer9;
    @Column(name = "answer10")
    private String answer10;

    // ===== Getters and Setters =====

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getQ1Id() {
        return q1Id;
    }


    public void setQ1Id(Long q1Id) {
        this.q1Id = q1Id;
    }

    public Long getQ2Id() {
        return q2Id;
    }

    public void setQ2Id(Long q2Id) {
        this.q2Id = q2Id;
    }

    public Long getQ3Id() {
        return q3Id;
    }

    public void setQ3Id(Long q3Id) {
        this.q3Id = q3Id;
    }

    public Long getQ4Id() {
        return q4Id;
    }

    public void setQ4Id(Long q4Id) {
        this.q4Id = q4Id;
    }

    public Long getQ5Id() {
        return q5Id;
    }

    public void setQ5Id(Long q5Id) {
        this.q5Id = q5Id;
    }

    public Long getQ6Id() {
        return q6Id;
    }

    public void setQ6Id(Long q6Id) {
        this.q6Id = q6Id;
    }

    public Long getQ7Id() {
        return q7Id;
    }

    public void setQ7Id(Long q7Id) {
        this.q7Id = q7Id;
    }

    public Long getQ8Id() {
        return q8Id;
    }

    public void setQ8Id(Long q8Id) {
        this.q8Id = q8Id;
    }

    public Long getQ9Id() {
        return q9Id;
    }

    public void setQ9Id(Long q9Id) {
        this.q9Id = q9Id;
    }

    public Long getQ10Id() {
        return q10Id;
    }

    public void setQ10Id(Long q10Id) {
        this.q10Id = q10Id;
    }



    public String getAnswer1() { return answer1; }
    public void setAnswer1(String answer1) { this.answer1 = answer1; }
    public String getAnswer2() { return answer2; }
    public void setAnswer2(String answer2) { this.answer2 = answer2; }
    public String getAnswer3() { return answer3; }
    public void setAnswer3(String answer3) { this.answer3 = answer3; }
    public String getAnswer4() { return answer4; }
    public void setAnswer4(String answer4) { this.answer4 = answer4; }
    public String getAnswer5() { return answer5; }
    public void setAnswer5(String answer5) { this.answer5 = answer5; }
    public String getAnswer6() { return answer6; }
    public void setAnswer6(String answer6) { this.answer6 = answer6; }
    public String getAnswer7() { return answer7; }
    public void setAnswer7(String answer7) { this.answer7 = answer7; }
    public String getAnswer8() { return answer8; }
    public void setAnswer8(String answer8) { this.answer8 = answer8; }
    public String getAnswer9() { return answer9; }
    public void setAnswer9(String answer9) { this.answer9 = answer9; }
    public String getAnswer10() { return answer10; }
    public void setAnswer10(String answer10) { this.answer10 = answer10; }
}
