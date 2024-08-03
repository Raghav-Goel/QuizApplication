package com.raghav.quizApplication.controller;

import com.raghav.quizApplication.entity.QuestionWrapper;
import com.raghav.quizApplication.entity.Quiz;
import com.raghav.quizApplication.entity.Response;
import com.raghav.quizApplication.service.serviceInterface.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
    @GetMapping("/getQuizQuestions/{quizId}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable Long quizId) throws Exception {
        List<QuestionWrapper> questionWrapperList=quizService.getQuestionsForQuiz(quizId);
        return new ResponseEntity<>(questionWrapperList,HttpStatus.OK);
    }
    @PostMapping("/createQuiz")
    public ResponseEntity<String> createQuiz(@RequestParam String title,@RequestParam String category, @RequestParam int qstNo){
        Long quizId=quizService.createQuiz(title,category,qstNo);
        return new ResponseEntity<>("Quiz has been created with id= "+quizId, HttpStatus.CREATED);
    }
    @PutMapping("/addQuestionToQuiz")
    public ResponseEntity<String> addQuestionToQuiz(@RequestParam Long quizId, @RequestParam Long qstNo) throws Exception {
        String s=quizService.updateQuestioninQuiz(quizId,qstNo);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }
    @PostMapping("/submitQuiz")
    public ResponseEntity<Integer> submitQuiz(@RequestBody List<Response> response) throws Exception {
        Integer totalMarks=quizService.getResult(response);
        return new ResponseEntity<>(totalMarks,HttpStatus.OK);
    }
}
