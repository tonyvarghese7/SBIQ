package com.example.quiz.repository;

import com.example.quiz.entity.UserQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserQuizRepository extends JpaRepository<UserQuiz, Long> {
  Optional<UserQuiz> findByUserId(Long userId);

  @Query(value = "SELECT user_quiz_id FROM user_quiz WHERE user_id = :userId", nativeQuery = true)
  List<Long> findQuestionIdsByUserId(@Param("userId") Long userId);
}
