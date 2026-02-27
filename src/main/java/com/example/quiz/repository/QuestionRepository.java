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
                SELECT user_quiz_id
                FROM user_quiz
                WHERE user_id = :userId
            )
            ORDER BY RAND()
            LIMIT 30
            """, nativeQuery = true)
    List<Question> findFreshQuestionsForUser(Long userId);

    @Query(value = """
            SELECT *
            FROM questions
            WHERE id NOT IN (
                SELECT user_quiz_id
                FROM user_quiz
                WHERE user_id = :userId
            )
            AND difficulty IN (:difficulties)
            ORDER BY RAND()
            LIMIT 30
            """, nativeQuery = true)
    List<Question> findFreshQuestionsForUserAndDifficulties(Long userId, List<String> difficulties);
}
