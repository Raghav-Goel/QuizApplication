package com.raghav.quizApplication.service.serviceInterface;

import com.raghav.quizApplication.entity.UserQuiz;

public interface UserQuizService {

    public UserQuiz findByUserIdAndQuizId(Long userId,Long quizId);
}
