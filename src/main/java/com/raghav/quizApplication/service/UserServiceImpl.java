package com.raghav.quizApplication.service;

import com.raghav.quizApplication.dao.UserDao;
import com.raghav.quizApplication.entity.Quiz;
import com.raghav.quizApplication.entity.Response;
import com.raghav.quizApplication.entity.User;
import com.raghav.quizApplication.service.serviceInterface.QuizService;
import com.raghav.quizApplication.service.serviceInterface.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    QuizService quizSerivce;
    @Override
    public Long createUser(User user) {
        userDao.save(user);
        return user.getUserId();
    }
    @Override
    public User getUser(Long userId){
        return userDao.findById(userId).get();
    }
    @Override
    public String addQuiz(Long userId,Long quizId){
        User user=userDao.findById(userId).get();
        Quiz quiz=quizSerivce.getQuiz(quizId);
        if(!user.getQuiz().contains(quiz)){
            user.getQuiz().add(quiz);
            return "Quiz id= "+quizId+" has been added to user with user id= "+userId;
        }
        return "Quiz id= "+quizId+" is already there with user who has user id= "+userId;
    }

//    public void attemptQuiz(Long userId, Long quiz_id, List<Response> response){
//        User user=userDao.findById(userId).get();
//        int marks=quizSerivce.getResult(response);
//
//    }
}
