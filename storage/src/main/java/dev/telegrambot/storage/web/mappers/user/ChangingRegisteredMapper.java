package dev.telegrambot.storage.web.mappers.user;

import dev.telegrambot.storage.domain.user.User;
import dev.telegrambot.storage.web.dto.user.ChangingRegisteredUserDto;
import dev.telegrambot.storage.web.mappers.Mappable;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChangingRegisteredMapper extends Mappable<User, ChangingRegisteredUserDto> {
}
