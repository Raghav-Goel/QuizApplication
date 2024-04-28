//package com.raghav.quizApplication.entity;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//
//import java.util.Objects;
//
//@Entity
//public class UserQuiz {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    Long userQuizId;
//    int marks;
//
//    public Long getUserQuizId() {
//        return userQuizId;
//    }
//
//    public void setUserQuizId(Long userQuizId) {
//        this.userQuizId = userQuizId;
//    }
//
//    public int getMarks() {
//        return marks;
//    }
//
//    public void setMarks(int marks) {
//        this.marks = marks;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        UserQuiz userQuiz = (UserQuiz) o;
//        return Objects.equals(userQuizId, userQuiz.userQuizId);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(userQuizId);
//    }
//
//    @Override
//    public String toString() {
//        return "UserQuiz{" +
//                "userQuizId=" + userQuizId +
//                ", marks=" + marks +
//                '}';
//    }
//}
