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
            UNION
            SELECT q2_id FROM user_quiz WHERE user_id = :userId AND q2_id IS NOT NULL
            UNION
            SELECT q3_id FROM user_quiz WHERE user_id = :userId AND q3_id IS NOT NULL
            UNION
            SELECT q4_id FROM user_quiz WHERE user_id = :userId AND q4_id IS NOT NULL
            UNION
            SELECT q5_id FROM user_quiz WHERE user_id = :userId AND q5_id IS NOT NULL
            UNION
            SELECT q6_id FROM user_quiz WHERE user_id = :userId AND q6_id IS NOT NULL
            UNION
            SELECT q7_id FROM user_quiz WHERE user_id = :userId AND q7_id IS NOT NULL
            UNION
            SELECT q8_id FROM user_quiz WHERE user_id = :userId AND q8_id IS NOT NULL
            UNION
            SELECT q9_id FROM user_quiz WHERE user_id = :userId AND q9_id IS NOT NULL
            UNION
            SELECT q10_id FROM user_quiz WHERE user_id = :userId AND q10_id IS NOT NULL
        )
        ORDER BY RAND()
        LIMIT 10
        """, nativeQuery = true)
    List<Question> findFreshQuestionsForUser(Long userId);
}
