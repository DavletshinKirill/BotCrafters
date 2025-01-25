package dev.telegrambot.storage.repository;

import dev.telegrambot.storage.domain.course.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<Course, UUID> {
    Optional<Course> findByCourseName(String name);
    Page<Course> findAll(Pageable pageable);

    Optional<Course> findCourseByCourseNameAndStartDate(String name, LocalDateTime startDate);
}
