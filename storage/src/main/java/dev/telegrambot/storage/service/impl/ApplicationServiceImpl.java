package dev.telegrambot.storage.service.impl;

import dev.telegrambot.storage.domain.application.Application;
import dev.telegrambot.storage.domain.enums.ApplicationStatus;
import dev.telegrambot.storage.domain.course.Course;
import dev.telegrambot.storage.domain.exception.ResourceNotFoundException;
import dev.telegrambot.storage.domain.user.User;
import dev.telegrambot.storage.repository.ApplicationRepository;
import dev.telegrambot.storage.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

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

    @Override
    public Application createApplication(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public List<Application> getApplications(int offset, int limit) {
        Pageable pageable = PageRequest.of(offset, limit);
        Page<Application> coursesPage = applicationRepository.findAll(pageable);
        return coursesPage.hasContent() ? new ArrayList<>(coursesPage.getContent()) : Collections.emptyList();
    }

    @Override
    public Application getApplication(UUID applicationId) {
        return applicationRepository.findById(applicationId).orElseThrow(
                () -> new ResourceNotFoundException(String.format("Application with id %s not found", applicationId))
        );
    }

    @Override
    public Application updateApplicationStatus(UUID applicationId, ApplicationStatus status) {
        Application application = getApplication(applicationId);
        application.setStatus(status);
        return applicationRepository.save(application);
    }
}
