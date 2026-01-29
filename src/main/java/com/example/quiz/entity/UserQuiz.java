package com.example.quiz.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

//Database Entity

@Entity
@Table(name = "user_quiz")
public class UserQuiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // primary key for each attempt

    @Column(name = "user_id")
    private Long userId; // One row per user

    // New field as requested
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // Automatically set created_at before persisting
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    // ===== Answers 1 to 30 =====
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
    @Column(name = "answer11")
    private String answer11;
    @Column(name = "answer12")
    private String answer12;
    @Column(name = "answer13")
    private String answer13;
    @Column(name = "answer14")
    private String answer14;
    @Column(name = "answer15")
    private String answer15;
    @Column(name = "answer16")
    private String answer16;
    @Column(name = "answer17")
    private String answer17;
    @Column(name = "answer18")
    private String answer18;
    @Column(name = "answer19")
    private String answer19;
    @Column(name = "answer20")
    private String answer20;
    @Column(name = "answer21")
    private String answer21;
    @Column(name = "answer22")
    private String answer22;
    @Column(name = "answer23")
    private String answer23;
    @Column(name = "answer24")
    private String answer24;
    @Column(name = "answer25")
    private String answer25;
    @Column(name = "answer26")
    private String answer26;
    @Column(name = "answer27")
    private String answer27;
    @Column(name = "answer28")
    private String answer28;
    @Column(name = "answer29")
    private String answer29;
    @Column(name = "answer30")
    private String answer30;

    // ===== Questions 1 to 30 =====
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
    @Column(name = "q11_id")
    private Long q11Id;
    @Column(name = "q12_id")
    private Long q12Id;
    @Column(name = "q13_id")
    private Long q13Id;
    @Column(name = "q14_id")
    private Long q14Id;
    @Column(name = "q15_id")
    private Long q15Id;
    @Column(name = "q16_id")
    private Long q16Id;
    @Column(name = "q17_id")
    private Long q17Id;
    @Column(name = "q18_id")
    private Long q18Id;
    @Column(name = "q19_id")
    private Long q19Id;
    @Column(name = "q20_id")
    private Long q20Id;
    @Column(name = "q21_id")
    private Long q21Id;
    @Column(name = "q22_id")
    private Long q22Id;
    @Column(name = "q23_id")
    private Long q23Id;
    @Column(name = "q24_id")
    private Long q24Id;
    @Column(name = "q25_id")
    private Long q25Id;
    @Column(name = "q26_id")
    private Long q26Id;
    @Column(name = "q27_id")
    private Long q27Id;
    @Column(name = "q28_id")
    private Long q28Id;
    @Column(name = "q29_id")
    private Long q29Id;
    @Column(name = "q30_id")
    private Long q30Id;

    // ===== Getters and Setters =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // Answers
    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public String getAnswer5() {
        return answer5;
    }

    public void setAnswer5(String answer5) {
        this.answer5 = answer5;
    }

    public String getAnswer6() {
        return answer6;
    }

    public void setAnswer6(String answer6) {
        this.answer6 = answer6;
    }

    public String getAnswer7() {
        return answer7;
    }

    public void setAnswer7(String answer7) {
        this.answer7 = answer7;
    }

    public String getAnswer8() {
        return answer8;
    }

    public void setAnswer8(String answer8) {
        this.answer8 = answer8;
    }

    public String getAnswer9() {
        return answer9;
    }

    public void setAnswer9(String answer9) {
        this.answer9 = answer9;
    }

    public String getAnswer10() {
        return answer10;
    }

    public void setAnswer10(String answer10) {
        this.answer10 = answer10;
    }

    public String getAnswer11() {
        return answer11;
    }

    public void setAnswer11(String answer11) {
        this.answer11 = answer11;
    }

    public String getAnswer12() {
        return answer12;
    }

    public void setAnswer12(String answer12) {
        this.answer12 = answer12;
    }

    public String getAnswer13() {
        return answer13;
    }

    public void setAnswer13(String answer13) {
        this.answer13 = answer13;
    }

    public String getAnswer14() {
        return answer14;
    }

    public void setAnswer14(String answer14) {
        this.answer14 = answer14;
    }

    public String getAnswer15() {
        return answer15;
    }

    public void setAnswer15(String answer15) {
        this.answer15 = answer15;
    }

    public String getAnswer16() {
        return answer16;
    }

    public void setAnswer16(String answer16) {
        this.answer16 = answer16;
    }

    public String getAnswer17() {
        return answer17;
    }

    public void setAnswer17(String answer17) {
        this.answer17 = answer17;
    }

    public String getAnswer18() {
        return answer18;
    }

    public void setAnswer18(String answer18) {
        this.answer18 = answer18;
    }

    public String getAnswer19() {
        return answer19;
    }

    public void setAnswer19(String answer19) {
        this.answer19 = answer19;
    }

    public String getAnswer20() {
        return answer20;
    }

    public void setAnswer20(String answer20) {
        this.answer20 = answer20;
    }

    public String getAnswer21() {
        return answer21;
    }

    public void setAnswer21(String answer21) {
        this.answer21 = answer21;
    }

    public String getAnswer22() {
        return answer22;
    }

    public void setAnswer22(String answer22) {
        this.answer22 = answer22;
    }

    public String getAnswer23() {
        return answer23;
    }

    public void setAnswer23(String answer23) {
        this.answer23 = answer23;
    }

    public String getAnswer24() {
        return answer24;
    }

    public void setAnswer24(String answer24) {
        this.answer24 = answer24;
    }

    public String getAnswer25() {
        return answer25;
    }

    public void setAnswer25(String answer25) {
        this.answer25 = answer25;
    }

    public String getAnswer26() {
        return answer26;
    }

    public void setAnswer26(String answer26) {
        this.answer26 = answer26;
    }

    public String getAnswer27() {
        return answer27;
    }

    public void setAnswer27(String answer27) {
        this.answer27 = answer27;
    }

    public String getAnswer28() {
        return answer28;
    }

    public void setAnswer28(String answer28) {
        this.answer28 = answer28;
    }

    public String getAnswer29() {
        return answer29;
    }

    public void setAnswer29(String answer29) {
        this.answer29 = answer29;
    }

    public String getAnswer30() {
        return answer30;
    }

    public void setAnswer30(String answer30) {
        this.answer30 = answer30;
    }

    // Questions
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

    public Long getQ11Id() {
        return q11Id;
    }

    public void setQ11Id(Long q11Id) {
        this.q11Id = q11Id;
    }

    public Long getQ12Id() {
        return q12Id;
    }

    public void setQ12Id(Long q12Id) {
        this.q12Id = q12Id;
    }

    public Long getQ13Id() {
        return q13Id;
    }

    public void setQ13Id(Long q13Id) {
        this.q13Id = q13Id;
    }

    public Long getQ14Id() {
        return q14Id;
    }

    public void setQ14Id(Long q14Id) {
        this.q14Id = q14Id;
    }

    public Long getQ15Id() {
        return q15Id;
    }

    public void setQ15Id(Long q15Id) {
        this.q15Id = q15Id;
    }

    public Long getQ16Id() {
        return q16Id;
    }

    public void setQ16Id(Long q16Id) {
        this.q16Id = q16Id;
    }

    public Long getQ17Id() {
        return q17Id;
    }

    public void setQ17Id(Long q17Id) {
        this.q17Id = q17Id;
    }

    public Long getQ18Id() {
        return q18Id;
    }

    public void setQ18Id(Long q18Id) {
        this.q18Id = q18Id;
    }

    public Long getQ19Id() {
        return q19Id;
    }

    public void setQ19Id(Long q19Id) {
        this.q19Id = q19Id;
    }

    public Long getQ20Id() {
        return q20Id;
    }

    public void setQ20Id(Long q20Id) {
        this.q20Id = q20Id;
    }

    public Long getQ21Id() {
        return q21Id;
    }

    public void setQ21Id(Long q21Id) {
        this.q21Id = q21Id;
    }

    public Long getQ22Id() {
        return q22Id;
    }

    public void setQ22Id(Long q22Id) {
        this.q22Id = q22Id;
    }

    public Long getQ23Id() {
        return q23Id;
    }

    public void setQ23Id(Long q23Id) {
        this.q23Id = q23Id;
    }

    public Long getQ24Id() {
        return q24Id;
    }

    public void setQ24Id(Long q24Id) {
        this.q24Id = q24Id;
    }

    public Long getQ25Id() {
        return q25Id;
    }

    public void setQ25Id(Long q25Id) {
        this.q25Id = q25Id;
    }

    public Long getQ26Id() {
        return q26Id;
    }

    public void setQ26Id(Long q26Id) {
        this.q26Id = q26Id;
    }

    public Long getQ27Id() {
        return q27Id;
    }

    public void setQ27Id(Long q27Id) {
        this.q27Id = q27Id;
    }

    public Long getQ28Id() {
        return q28Id;
    }

    public void setQ28Id(Long q28Id) {
        this.q28Id = q28Id;
    }

    public Long getQ29Id() {
        return q29Id;
    }

    public void setQ29Id(Long q29Id) {
        this.q29Id = q29Id;
    }

    public Long getQ30Id() {
        return q30Id;
    }

    public void setQ30Id(Long q30Id) {
        this.q30Id = q30Id;
    }
}
