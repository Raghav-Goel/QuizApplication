package com.raghav.quizApplication.dao;

import com.raghav.quizApplication.entity.Quiz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizDao extends CrudRepository<Quiz,Long> {


}
