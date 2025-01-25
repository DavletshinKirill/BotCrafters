package dev.telegrambot.storage.web.mappers;

import dev.telegrambot.storage.domain.user.User;
import dev.telegrambot.storage.web.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends Mappable<User, UserDto> {
}
