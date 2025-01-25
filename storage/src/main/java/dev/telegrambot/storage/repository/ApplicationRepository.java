package dev.telegrambot.storage.repository;

import dev.telegrambot.storage.domain.application.Application;
import dev.telegrambot.storage.domain.course.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApplicationRepository extends JpaRepository<Application, UUID> {
    Page<Application> findAll(Pageable pageable);
}
