package dev.telegrambot.storage.repository;

import dev.telegrambot.storage.domain.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID> {
    Optional<Course> findByName(String name);
}
