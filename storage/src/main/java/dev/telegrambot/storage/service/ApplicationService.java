package dev.telegrambot.storage.service;

import dev.telegrambot.storage.domain.application.Application;
import dev.telegrambot.storage.domain.course.Course;
import dev.telegrambot.storage.domain.enums.ApplicationStatus;
import dev.telegrambot.storage.domain.user.User;

import java.util.List;
import java.util.UUID;

public interface ApplicationService {
    Application createApplication(User user, Course course);
    Application createApplication(Application application);

    List<Application> getApplications(int offset, int limit);
    Application getApplication(UUID applicationId);
    Application updateApplicationStatus(UUID applicationId, ApplicationStatus status);
}
