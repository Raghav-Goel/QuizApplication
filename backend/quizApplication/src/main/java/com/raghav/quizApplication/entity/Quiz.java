package com.raghav.quizApplication.entity;
import jakarta.persistence.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long quizId;
    String title;
    @ManyToMany(cascade= CascadeType.ALL)
    @JoinTable(name="quiz_question", joinColumns = @JoinColumn(name="quiz_id"), inverseJoinColumns = @JoinColumn(name="qst_id"))
    List<Question> questionList=new ArrayList<>();

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "quizId=" + quizId +
                ", title='" + title + '\'' +
                ", questionList=" + questionList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quiz quiz = (Quiz) o;
        return Objects.equals(quizId, quiz.quizId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quizId);
    }
}
