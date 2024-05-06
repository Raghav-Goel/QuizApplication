package com.raghav.quizApplication.service.serviceInterface;

import com.raghav.quizApplication.entity.Response;
import com.raghav.quizApplication.entity.User;

import java.util.List;

public interface UserService {
    public Long createUser(User user);
    public User getUser(Long userId);

    public String addQuiz(Long userId,Long quiz_id);
    public String submitQuiz(Long userId, Long quizId, List<Response> response);
}
