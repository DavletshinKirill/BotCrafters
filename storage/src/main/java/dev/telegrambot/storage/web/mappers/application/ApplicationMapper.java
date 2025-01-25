package dev.telegrambot.storage.web.mappers.application;

import dev.telegrambot.storage.domain.application.Application;
import dev.telegrambot.storage.web.dto.application.ApplicationDto;
import dev.telegrambot.storage.web.dto.user.RegisteredUserDto;
import dev.telegrambot.storage.web.mappers.Mappable;
import dev.telegrambot.storage.web.mappers.course.CourseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {RegisteredUserDto.class, CourseMapper.class})
public interface ApplicationMapper extends Mappable<Application, ApplicationDto> {
}
