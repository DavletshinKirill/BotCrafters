package dev.telegrambot.storage.web.mappers.adminUser;

import dev.telegrambot.storage.domain.user.AdminUser;
import dev.telegrambot.storage.web.dto.adminUser.ChangingAdminUserDto;
import dev.telegrambot.storage.web.mappers.Mappable;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChangingAdminUserMapper extends Mappable<AdminUser, ChangingAdminUserDto> {
}
