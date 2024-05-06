package com.raghav.quizApplication.service;

import com.raghav.quizApplication.dao.QuestionDao;
import com.raghav.quizApplication.dao.QuizDao;
import com.raghav.quizApplication.entity.Question;
import com.raghav.quizApplication.entity.QuestionWrapper;
import com.raghav.quizApplication.entity.Quiz;
import com.raghav.quizApplication.entity.Response;
import com.raghav.quizApplication.service.serviceInterface.QuestionService;
import com.raghav.quizApplication.service.serviceInterface.QuizService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class QuizServiceImpl implements QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;
    @Autowired
    QuestionService questionservice;

    @Override
    public Quiz getQuiz(Long quizId) {
        return quizDao.findById(quizId).get();
    }

    @Override
    public Long createQuiz(String title,String category,int qstNo) {
        Quiz quiz=new Quiz();
        quiz.setQuestionList(questionservice.getByCategoryAndQuestionNumber(category,qstNo));
        System.out.println(quiz.getQuestionList());
        quiz.setTitle(title);
        quizDao.save(quiz);
        return quiz.getQuizId();
    }

    @Override
    public List<QuestionWrapper> getQuestionsForQuiz(Long quizId) throws Exception {
        Optional<Quiz> optionalQuiz=quizDao.findById(quizId);
        Quiz quiz= optionalQuiz.orElseThrow(Exception::new );
        List<QuestionWrapper> questionWrapperList=new ArrayList<>();
        quiz.getQuestionList().forEach(question->{
            QuestionWrapper questionWrapper=new QuestionWrapper();
            questionWrapper.setQstId(question.getQstId());
            questionWrapper.setDescription(question.getDescription());
            questionWrapper.setOption1(question.getOption1());
            questionWrapper.setOption2(question.getOption2());
            questionWrapper.setOption3(question.getOption3());
            questionWrapper.setOption4(question.getOption4());
            questionWrapperList.add(questionWrapper);
        });
        return questionWrapperList;
    }

    @Override
    public String updateQuestioninQuiz(Long quizId, Long qstid) throws Exception {
        Optional<Quiz> optionalQuiz=quizDao.findById(quizId);
        Quiz quiz= optionalQuiz.orElseThrow(Exception::new );
        Question question=questionservice.getQuestionByQuestionId(qstid);
        quiz.getQuestionList().add(question);
        return "Done";
    }

    @Override
    public Integer getResult(List<Response> response){
        int marks=0;
        for (Response r : response) {
            Question question = questionDao.findById(r.getId()).get();
            if (question.getAns().equals(r.getResponse())) marks++;
        }
        return marks;
    }
}
