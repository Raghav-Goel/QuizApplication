package com.raghav.quizApplication.dao;

import com.raghav.quizApplication.entity.Quiz;
import com.raghav.quizApplication.entity.User;
import com.raghav.quizApplication.entity.UserQuiz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserQuizDao extends CrudRepository<UserQuiz,Long> {
    UserQuiz findByUserAndQuiz(User user, Quiz quiz);
}
