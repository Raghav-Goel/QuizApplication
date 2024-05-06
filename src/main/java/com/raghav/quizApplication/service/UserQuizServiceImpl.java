package com.raghav.quizApplication.service;

import com.raghav.quizApplication.dao.UserQuizDao;
import com.raghav.quizApplication.entity.UserQuiz;
import com.raghav.quizApplication.service.serviceInterface.UserQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserQuizServiceImpl implements UserQuizService {
    @Autowired
    UserQuizDao userQuizDao;

    @Override
    public String updateMarks(Long userQuizId,int marks) {
        UserQuiz userQuiz=userQuizDao.findById(userQuizId).get();
        userQuiz.setMarks(marks);
        return "Updated marks= "+marks+" for userQuizId= "+userQuizId;
    }
}
