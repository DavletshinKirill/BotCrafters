package dev.telegrambot.storage.service.impl;

import dev.telegrambot.storage.domain.application.Application;
import dev.telegrambot.storage.domain.enums.ApplicationStatus;
import dev.telegrambot.storage.domain.course.Course;
import dev.telegrambot.storage.domain.user.User;
import dev.telegrambot.storage.repository.ApplicationRepository;
import dev.telegrambot.storage.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    @Override
    public Application createApplication(User user, Course course) {
        Application application = Application.builder()
                .createdAt(LocalDateTime.now())
                .user(user)
                .course(course)
                .status(ApplicationStatus.ACCEPTED)
                .build();
        return applicationRepository.save(application);
    }
}
