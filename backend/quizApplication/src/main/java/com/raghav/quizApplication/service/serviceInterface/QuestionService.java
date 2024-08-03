package com.raghav.quizApplication.service.serviceInterface;

import com.raghav.quizApplication.entity.Question;

import java.util.List;

public interface QuestionService {
    public Question getQuestionByQuestionId(Long qstId);
    public List<Question> getAllQuestions();
    public List<Question> getQuestionsByDescriptionLike(String description);
    public List<Question> getQuestionsByCategory(String category);
    public List<Question> getQuestionsByLevel(String level);
    public List<Question> getQuestionsByCategoryAndLevel(String category,String level);
    public Long createQuestion(Question question);
    public List<Question> getByCategoryAndQuestionNumber(String category,int questionNumber);


}
