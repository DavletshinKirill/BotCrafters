package dev.telegrambot.storage.service.impl;

import dev.telegrambot.storage.domain.exception.CourseNotFoundException;
import dev.telegrambot.storage.domain.course.Course;
import dev.telegrambot.storage.repository.CourseRepository;
import dev.telegrambot.storage.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
