package dev.telegrambot.storage.service.impl;

import dev.telegrambot.storage.domain.course.Course;
import dev.telegrambot.storage.domain.user.User;
import dev.telegrambot.storage.service.ApplicationService;
import dev.telegrambot.storage.service.BotService;
import dev.telegrambot.storage.service.CourseService;
import dev.telegrambot.storage.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BotServiceImpl implements BotService {

    private final UserService userService;
    private final CourseService courseService;
    private final ApplicationService applicationService;

    @Override
    public void createUser(User user, String courseName) {
        User createdUser = userService.createUser(user);
        Course course = courseService.getCourse(courseName);
        applicationService.createApplication(createdUser, course);
    }
}
