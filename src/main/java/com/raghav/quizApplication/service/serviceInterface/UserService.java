package com.raghav.quizApplication.service.serviceInterface;

import com.raghav.quizApplication.entity.User;
import org.springframework.data.jpa.repository.Query;

public interface UserService {
    public Long createUser(User user);
    public User getUser(Long userId);

    public String addQuiz(Long userId,Long quiz_id);
}
