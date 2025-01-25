package dev.telegrambot.storage.web.dto.adminUser;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class AdminUserDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @NotNull(message = "Id must be not null.")
    private UUID id;

    @NotBlank(message = "Имя пользователя обязательно")
    private String lastName;

    @NotBlank(message = "Фамилия пользователя обязательна")
    private String firstname;

    @NotBlank(message = "Имя пользователя обязательно")
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

}
