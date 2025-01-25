package dev.telegrambot.storage.web.mappers.user;

import dev.telegrambot.storage.domain.user.User;
import dev.telegrambot.storage.web.dto.user.RegisteredUserDto;
import dev.telegrambot.storage.web.mappers.Mappable;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegisteredUserMapper extends Mappable<User, RegisteredUserDto> {
}
