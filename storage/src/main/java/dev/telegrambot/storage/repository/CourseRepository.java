package dev.telegrambot.storage.repository;

import dev.telegrambot.storage.domain.course.Course;
import dev.telegrambot.storage.domain.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID> {
    Optional<Course> findByName(String name);
    Page<Course> findAll(Pageable pageable);
    Optional<Course> findCourseByNameAndStartDate(String name, LocalDateTime startDate);
}
