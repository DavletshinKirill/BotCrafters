package dev.telegrambot.storage.service;

import dev.telegrambot.storage.domain.application.Application;
import dev.telegrambot.storage.domain.course.Course;
import dev.telegrambot.storage.domain.user.User;

public interface ApplicationService {
    Application createApplication(User user, Course course);
}
