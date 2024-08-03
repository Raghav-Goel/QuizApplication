package com.raghav.quizApplication.controller;

import com.raghav.quizApplication.entity.Response;
import com.raghav.quizApplication.entity.User;
import com.raghav.quizApplication.service.serviceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/User/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Long userId){
        User user= userService.getUser(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody User user){
        Long userId=userService.createUser(user);
        return new ResponseEntity<>("The user has been created with userId= "+userId,HttpStatus.CREATED);
    }
    @PostMapping("/addQuiz")
    public ResponseEntity<String> addQuizToUser(@RequestParam Long userId,@RequestParam Long quizId){
        String s=userService.addQuiz(userId,quizId);
        return new ResponseEntity<>(s,HttpStatus.CREATED);
    }
    @PostMapping("/submitQuiz")
    public ResponseEntity<String> submitQuiz(@RequestParam Long userId,@RequestParam Long quizId,@RequestBody List<Response> response) throws Exception {
        String totalMarks=userService.submitQuiz(userId,quizId,response);
        return new ResponseEntity<>(totalMarks,HttpStatus.OK);
    }
}
