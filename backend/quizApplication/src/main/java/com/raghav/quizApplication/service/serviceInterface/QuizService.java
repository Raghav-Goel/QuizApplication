package com.raghav.quizApplication.service.serviceInterface;

import com.raghav.quizApplication.entity.QuestionWrapper;
import com.raghav.quizApplication.entity.Quiz;
import com.raghav.quizApplication.entity.Response;

import java.util.List;

public interface QuizService {
    public Quiz getQuiz(Long quizId);
    public Long createQuiz(String title,String category,int qstNo);
    public List<QuestionWrapper> getQuestionsForQuiz(Long quizId) throws Exception;
    public String updateQuestioninQuiz(Long quizId,Long qstid) throws Exception;

    Integer getResult(List<Response> response);
}
