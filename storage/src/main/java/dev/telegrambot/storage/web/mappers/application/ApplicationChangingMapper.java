package dev.telegrambot.storage.web.mappers.application;

import dev.telegrambot.storage.domain.application.Application;
import dev.telegrambot.storage.web.dto.application.ApplicationChangingDto;
import dev.telegrambot.storage.web.dto.user.RegisteredUserDto;
import dev.telegrambot.storage.web.mappers.Mappable;
import dev.telegrambot.storage.web.mappers.course.CourseMapper;
import dev.telegrambot.storage.web.mappers.user.ChangingRegisteredMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {RegisteredUserDto.class, CourseMapper.class})
public interface ApplicationChangingMapper extends Mappable<Application, ApplicationChangingDto> {
}
