package com.example.quiz.repository;

import com.example.quiz.entity.UserQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserQuizRepository extends JpaRepository<UserQuiz, Long> {
  Optional<UserQuiz> findByUserId(Long userId);

  @Query(value = """
        SELECT q1_id FROM user_quiz WHERE user_id = :userId
        UNION
        SELECT q2_id FROM user_quiz WHERE user_id = :userId
        UNION
        SELECT q3_id FROM user_quiz WHERE user_id = :userId
        UNION
        SELECT q4_id FROM user_quiz WHERE user_id = :userId
        UNION
        SELECT q5_id FROM user_quiz WHERE user_id = :userId
        UNION
        SELECT q6_id FROM user_quiz WHERE user_id = :userId
        UNION
        SELECT q7_id FROM user_quiz WHERE user_id = :userId
        UNION
        SELECT q8_id FROM user_quiz WHERE user_id = :userId
        UNION
        SELECT q9_id FROM user_quiz WHERE user_id = :userId
        UNION
        SELECT q10_id FROM user_quiz WHERE user_id = :userId
      """, nativeQuery = true)
  List<Long> findQuestionIdsByUserId(@Param("userId") Long userId);
}
