package com.raghav.quizApplication.dao;

import com.raghav.quizApplication.entity.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends CrudRepository<Question,Long> {
    List<Question> findByDescriptionLike(String description);
    List<Question> findByCategory(String category);
    List<Question> findByLevel(String level);
    List<Question> findByCategoryAndLevel(String category,String Level);
    @Query(value = "select * from Question where category=:category  order by rand() limit :questionNumber", nativeQuery = true)
    List<Question> findByCategoryAndQuestionNumber(String category,int questionNumber);



}
