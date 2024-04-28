package com.raghav.quizApplication.entity;

import com.raghav.quizApplication.entity.enumClasses.QuestionLevel;
import com.raghav.quizApplication.entity.enumClasses.QuestionType;
import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long qstId;
    String description;
    String option1;
    String option2;
    String option3;
    String option4;
    @Column(name="type")
    @Enumerated(EnumType.STRING)
    QuestionType type;
    @Column(name="level")
    @Enumerated(EnumType.STRING)
    QuestionLevel level;
    String ans;
    String category;

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    public QuestionLevel getLevel() {
        return level;
    }

    public void setLevel(QuestionLevel level) {
        this.level = level;
    }

    public Long getQstId() {
        return qstId;
    }

    public void setQstId(Long qstId) {
        this.qstId = qstId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public void setQuestionType(String questionType) {
        this.type = type;
    }

    public void setQuestionLevel(String questionLevel) {
        this.level = level;
    }
    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(qstId, question.qstId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qstId);
    }

    @Override
    public String toString() {
        return "Question{" +
                "qstId=" + qstId +
                ", description='" + description + '\'' +
                ", option1='" + option1 + '\'' +
                ", option2='" + option2 + '\'' +
                ", option3='" + option3 + '\'' +
                ", option4='" + option4 + '\'' +
                ", type='" + type + '\'' +
                ", level='" + level + '\'' +
                ", ans='" + ans + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

}
