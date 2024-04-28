package com.raghav.quizApplication.entity;

import java.util.Objects;

public class QuestionWrapper {
    Long qstId;
    String description;
    String option1;
    String option2;
    String option3;
    String option4;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionWrapper that = (QuestionWrapper) o;
        return Objects.equals(qstId, that.qstId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qstId);
    }

    @Override
    public String toString() {
        return "QuestionWrapper{" +
                "qstId=" + qstId +
                ", description='" + description + '\'' +
                ", option1='" + option1 + '\'' +
                ", option2='" + option2 + '\'' +
                ", option3='" + option3 + '\'' +
                ", option4='" + option4 + '\'' +
                '}';
    }
}
