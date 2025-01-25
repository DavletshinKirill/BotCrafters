package dev.telegrambot.storage.service;

import dev.telegrambot.storage.domain.course.Course;

import java.util.List;

public interface CourseService {
    Course getCourse(String courseName);

    List<String> getAllCoursesTitle();
}
