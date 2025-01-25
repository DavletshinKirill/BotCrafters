package dev.telegrambot.storage.service;

import dev.telegrambot.storage.domain.course.Course;

import java.util.List;
import java.util.UUID;

public interface CourseService {
    Course getCourse(String courseName);

    List<String> getAllCoursesTitle();

    List<Course> getAllCourses(int offset, int limit);
    Course createCourse(Course course);
    Course getCourse(UUID courseId);


}
