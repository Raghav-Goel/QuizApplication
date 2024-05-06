package com.raghav.quizApplication.service;

import com.raghav.quizApplication.dao.UserQuizDao;
import com.raghav.quizApplication.entity.Quiz;
import com.raghav.quizApplication.entity.User;
import com.raghav.quizApplication.entity.UserQuiz;
import com.raghav.quizApplication.service.serviceInterface.QuizService;
import com.raghav.quizApplication.service.serviceInterface.UserQuizService;
import com.raghav.quizApplication.service.serviceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserQuizServiceImpl implements UserQuizService {
    @Autowired
    UserQuizDao userQuizDao;
    @Autowired
    UserService userService;
    @Autowired
    QuizService quizService;
    @Override
    public UserQuiz findByUserIdAndQuizId(Long userId, Long quizId) {
        User user=userService.getUser(userId);
        Quiz quiz=quizService.getQuiz(quizId);
        UserQuiz userQuiz=userQuizDao.findByUserAndQuiz(user,quiz);
        System.out.println(userQuiz);
        return userQuiz;
    }
}
