package dev.telegrambot.storage.service.impl;

import dev.telegrambot.storage.domain.exception.CourseNotFoundException;
import dev.telegrambot.storage.domain.course.Course;
import dev.telegrambot.storage.domain.exception.ResourceAlreadyExist;
import dev.telegrambot.storage.domain.exception.UserAlreadyExist;
import dev.telegrambot.storage.domain.exception.UserNotFoundException;
import dev.telegrambot.storage.domain.user.User;
import dev.telegrambot.storage.repository.CourseRepository;
import dev.telegrambot.storage.service.CourseService;
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
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public Course getCourse(String courseName) {
        return courseRepository.findByName(courseName).orElseThrow(
                () -> new CourseNotFoundException(String.format("Course with name %s not found", courseName))
        );
    }

    @Override
    public List<String> getAllCoursesTitle() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream().map(Course::getName).toList();
    }

    @Override
    public List<Course> getAllCourses(int offset, int limit) {
        Pageable pageable = PageRequest.of(offset, limit);
        Page<Course> coursesPage = courseRepository.findAll(pageable);
        return coursesPage.hasContent() ? new ArrayList<>(coursesPage.getContent()) : Collections.emptyList();
    }

    @Override
    public Course createCourse(Course course) {
        try {
            getCourseByNameAndDateStart(course.getName(), course.getStartDate());
            throw new ResourceAlreadyExist(String.format("Cource with name: %s and date_start exist", course.getName(), course.getStartDate().toString()));
        } catch (CourseNotFoundException e) {
            return courseRepository.save(course);
        }
    }

    @Override
    public Course getCourse(UUID courseId) {
        return courseRepository.findById(courseId).orElseThrow(
                () -> new CourseNotFoundException(String.format("Course with id %s not found", courseId))
        );
    }

    private Course getCourseByNameAndDateStart(String courseName, LocalDateTime startDate) {
        return courseRepository.findCourseByNameAndStartDate(courseName, startDate).orElseThrow(
                () -> new CourseNotFoundException(String.format("Course with name %s and startDate %s not found", courseName, startDate.toString()))
        );
    }
}
