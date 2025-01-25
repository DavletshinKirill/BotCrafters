package dev.telegrambot.storage.web.controller;

import dev.telegrambot.storage.domain.application.Application;
import dev.telegrambot.storage.domain.course.Course;
import dev.telegrambot.storage.domain.enums.ApplicationStatus;
import dev.telegrambot.storage.service.ApplicationService;
import dev.telegrambot.storage.service.CourseService;
import dev.telegrambot.storage.web.dto.application.ApplicationChangingDto;
import dev.telegrambot.storage.web.dto.application.ApplicationDto;
import dev.telegrambot.storage.web.dto.course.ChangingCourseDto;
import dev.telegrambot.storage.web.dto.course.CourseDto;
import dev.telegrambot.storage.web.mappers.application.ApplicationChangingMapper;
import dev.telegrambot.storage.web.mappers.application.ApplicationMapper;
import dev.telegrambot.storage.web.mappers.course.ChangingCourseMapper;
import dev.telegrambot.storage.web.mappers.course.CourseMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/courses")
@Tag(name = "Courses", description = "Управление курсами")
@Slf4j
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;
    private final CourseMapper courseMapper;
    private final ChangingCourseMapper changingCourseMapper;

    @Operation(summary = "Получение информации о курсе")
    @GetMapping("{course_id}")
    public CourseDto getCourse(UUID course_id) {
        Course course = courseService.getCourse(course_id);
        return courseMapper.toDTO(course);
    }

    @Operation(summary = "Получение списка направлений по обучению (курсов)й")
    @GetMapping()
    public List<CourseDto> getCourses(@RequestParam int offset, @RequestParam int limit) {
        List<Course> courses = courseService.getAllCourses(offset, limit);
        return courseMapper.toDTO(courses);
    }

    @Operation(summary = "Обновление данных о курсе (только для администратора)")
    @PatchMapping("{course_id}")
    public CourseDto updateApplication(@RequestBody ChangingCourseDto changingCourseDto, @PathVariable UUID course_id) {
        Course course = changingCourseMapper.toEntity(changingCourseDto);
        course.setId(course_id);
        Course updatedCourses = courseService.createCourse(course);
        return courseMapper.toDTO(updatedCourses);
    };

    @Operation(summary = "Создание нового курса (только для администратора)")
    @PostMapping
    public CourseDto createApplication(@RequestBody @Valid ChangingCourseDto changingCourseDto) {
        Course course = changingCourseMapper.toEntity(changingCourseDto);
        Course createdCourse = courseService.createCourse(course);
        return courseMapper.toDTO(createdCourse);
    }
}
