package com.raghav.quizApplication.controller;

import com.raghav.quizApplication.entity.Question;
import com.raghav.quizApplication.service.serviceInterface.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("/getAllquestions")
    public ResponseEntity<List<Question>> getAllQuestion(){
        List<Question> questionList=questionService.getAllQuestions();
        return new ResponseEntity<>(questionList, HttpStatus.OK);
    }
    @GetMapping("/questions/category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        List<Question> questionList=questionService.getQuestionsByCategory(category);
        return new ResponseEntity<>(questionList, HttpStatus.OK);
    }
    @GetMapping("/questions/level/{level}")
    public ResponseEntity<List<Question>> getQuestionsByLevel(@PathVariable String level){
        List<Question> questionList=questionService.getQuestionsByLevel(level);
        return new ResponseEntity<>(questionList, HttpStatus.OK);
    }
    @GetMapping("/questions/description/{description}")
    public ResponseEntity<List<Question>> getQuestionsByDescription(@PathVariable String description){
        List<Question> questionList=questionService.getQuestionsByDescriptionLike(description);
        return new ResponseEntity<>(questionList, HttpStatus.OK);
    }
    @GetMapping("/questions/categoryAndLevel")
    public ResponseEntity<List<Question>> getQuestionsByCategoryAndLevel(@RequestParam String category,@RequestParam String level){
        List<Question> questionList=questionService.getQuestionsByCategoryAndLevel(category,level);
        return new ResponseEntity<>(questionList, HttpStatus.OK);
    }
    @GetMapping("/questions/categoryAndQstNo")
    public ResponseEntity<List<Question>> getQuestionsByCategoryAndQuestionNumber(@RequestParam String category,@RequestParam int qst_no){
        List<Question> questionList=questionService.getByCategoryAndQuestionNumber(category,qst_no);
        return new ResponseEntity<>(questionList, HttpStatus.OK);
    }
    @PostMapping("/createquestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        Long qstId=questionService.createQuestion(question);
        if(qstId>=1)return new ResponseEntity<>("Question is created successfully",HttpStatus.CREATED);
        return new ResponseEntity<>("Error which creating the question",HttpStatus.BAD_REQUEST);

    }
}
