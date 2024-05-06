package com.raghav.quizApplication.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class UserQuiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userQuizId;
    int marks;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    User user;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="quiz_id")
    Quiz quiz;

    public Long getUserQuizId() {
        return userQuizId;
    }

    public void setUserQuizId(Long userQuizId) {
        this.userQuizId = userQuizId;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserQuiz userQuiz = (UserQuiz) o;
        return Objects.equals(userQuizId, userQuiz.userQuizId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userQuizId);
    }

    @Override
    public String toString() {
        return "UserQuiz{" +
                "userQuizId=" + userQuizId +
                ", marks=" + marks +
                ", user=" + user +
                ", quiz=" + quiz +
                '}';
    }
}
