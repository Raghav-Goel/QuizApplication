package com.raghav.quizApplication.controller;

import com.raghav.quizApplication.entity.UserQuiz;
import com.raghav.quizApplication.service.serviceInterface.UserQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user_quiz_details")
public class UserQuizController {
    @Autowired
    UserQuizService userQuizService;

    @GetMapping("/getUserQuizInfo")
    public ResponseEntity<UserQuiz> getUserAndQuizInfo(@RequestParam Long userId, @RequestParam Long quizId){
        UserQuiz userQuiz=userQuizService.findByUserIdAndQuizId(userId,quizId);
        return new ResponseEntity<>(userQuiz, HttpStatus.OK);
    }
}
