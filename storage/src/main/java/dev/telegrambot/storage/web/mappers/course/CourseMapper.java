package dev.telegrambot.storage.web.mappers.course;

import dev.telegrambot.storage.domain.course.Course;
import dev.telegrambot.storage.web.dto.course.CourseDto;
import dev.telegrambot.storage.web.mappers.Mappable;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper extends Mappable<Course, CourseDto> {
}
