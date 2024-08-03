package com.raghav.quizApplication.service;

import com.raghav.quizApplication.dao.QuestionDao;
import com.raghav.quizApplication.entity.Question;
import com.raghav.quizApplication.service.serviceInterface.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service(value="QuestionService")
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionDao questionDao;

    @Override
    public Question getQuestionByQuestionId(Long qstId) {
        return questionDao.findById(qstId).get();
    }

    @Override
    public List<Question> getAllQuestions() {
        Iterable<Question> questions=questionDao.findAll();
        List<Question> findAllQuestions=new ArrayList<>();
        questions.forEach(findAllQuestions::add);
        return findAllQuestions;
    }

    @Override
    public List<Question> getQuestionsByDescriptionLike(String description) {
        return questionDao.findByDescriptionLike(description);
    }

    @Override
    public List<Question> getQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    @Override
    public List<Question> getQuestionsByLevel(String level){
        return questionDao.findByLevel(level);
    }

    @Override
    public List<Question> getQuestionsByCategoryAndLevel(String category, String level) {
        return questionDao.findByCategoryAndLevel(category,level);
    }

    @Override
    public Long createQuestion(Question question) {
        questionDao.save(question);
        return question.getQstId();
    }

    @Override
    public List<Question> getByCategoryAndQuestionNumber(String category, int questionNumber) {
        return questionDao.findByCategoryAndQuestionNumber(category,questionNumber);
    }
}
