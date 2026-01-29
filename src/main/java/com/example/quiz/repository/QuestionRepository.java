package com.example.quiz.repository;

import com.example.quiz.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query(value = """
            SELECT *
            FROM questions
            WHERE id NOT IN (
                SELECT q1_id FROM user_quiz WHERE user_id = :userId AND q1_id IS NOT NULL
                UNION SELECT q2_id FROM user_quiz WHERE user_id = :userId AND q2_id IS NOT NULL
                UNION SELECT q3_id FROM user_quiz WHERE user_id = :userId AND q3_id IS NOT NULL
                UNION SELECT q4_id FROM user_quiz WHERE user_id = :userId AND q4_id IS NOT NULL
                UNION SELECT q5_id FROM user_quiz WHERE user_id = :userId AND q5_id IS NOT NULL
                UNION SELECT q6_id FROM user_quiz WHERE user_id = :userId AND q6_id IS NOT NULL
                UNION SELECT q7_id FROM user_quiz WHERE user_id = :userId AND q7_id IS NOT NULL
                UNION SELECT q8_id FROM user_quiz WHERE user_id = :userId AND q8_id IS NOT NULL
                UNION SELECT q9_id FROM user_quiz WHERE user_id = :userId AND q9_id IS NOT NULL
                UNION SELECT q10_id FROM user_quiz WHERE user_id = :userId AND q10_id IS NOT NULL
                UNION SELECT q11_id FROM user_quiz WHERE user_id = :userId AND q11_id IS NOT NULL
                UNION SELECT q12_id FROM user_quiz WHERE user_id = :userId AND q12_id IS NOT NULL
                UNION SELECT q13_id FROM user_quiz WHERE user_id = :userId AND q13_id IS NOT NULL
                UNION SELECT q14_id FROM user_quiz WHERE user_id = :userId AND q14_id IS NOT NULL
                UNION SELECT q15_id FROM user_quiz WHERE user_id = :userId AND q15_id IS NOT NULL
                UNION SELECT q16_id FROM user_quiz WHERE user_id = :userId AND q16_id IS NOT NULL
                UNION SELECT q17_id FROM user_quiz WHERE user_id = :userId AND q17_id IS NOT NULL
                UNION SELECT q18_id FROM user_quiz WHERE user_id = :userId AND q18_id IS NOT NULL
                UNION SELECT q19_id FROM user_quiz WHERE user_id = :userId AND q19_id IS NOT NULL
                UNION SELECT q20_id FROM user_quiz WHERE user_id = :userId AND q20_id IS NOT NULL
                UNION SELECT q21_id FROM user_quiz WHERE user_id = :userId AND q21_id IS NOT NULL
                UNION SELECT q22_id FROM user_quiz WHERE user_id = :userId AND q22_id IS NOT NULL
                UNION SELECT q23_id FROM user_quiz WHERE user_id = :userId AND q23_id IS NOT NULL
                UNION SELECT q24_id FROM user_quiz WHERE user_id = :userId AND q24_id IS NOT NULL
                UNION SELECT q25_id FROM user_quiz WHERE user_id = :userId AND q25_id IS NOT NULL
                UNION SELECT q26_id FROM user_quiz WHERE user_id = :userId AND q26_id IS NOT NULL
                UNION SELECT q27_id FROM user_quiz WHERE user_id = :userId AND q27_id IS NOT NULL
                UNION SELECT q28_id FROM user_quiz WHERE user_id = :userId AND q28_id IS NOT NULL
                UNION SELECT q29_id FROM user_quiz WHERE user_id = :userId AND q29_id IS NOT NULL
                UNION SELECT q30_id FROM user_quiz WHERE user_id = :userId AND q30_id IS NOT NULL
            )
            ORDER BY RAND()
            LIMIT 30
            """, nativeQuery = true)
    List<Question> findFreshQuestionsForUser(Long userId);
}
