package dev.telegrambot.storage.web.dto;

import dev.telegrambot.storage.domain.enums.Roles;
import dev.telegrambot.storage.web.dto.validators.OnUpdate;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
public class UserDto {
    @NotNull(
            message = "Id must be not null.",
            groups = OnUpdate.class
    )
    private UUID id;
    private String name;
    private String lastName;
    private String phone;
    private String city;
    private String email;
    private Roles role;
    private Date registrationDate;
}
