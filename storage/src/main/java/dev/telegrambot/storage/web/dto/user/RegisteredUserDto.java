package dev.telegrambot.storage.web.dto.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.telegrambot.storage.domain.enums.Roles;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

public class RegisteredUserDto {

    @NotNull(message = "Id must be not null.")
    private UUID id;

    @NotBlank(message = "Имя пользователя обязательно")
    private String name;
    @NotBlank(message = "Фамилия пользователя обязательна")
    private String lastName;
    @NotBlank(message = "Имя пользователя обязательно")
    private String phone;
    @NotBlank(message = "Имя пользователя обязательно")
    private String city;
    @NotBlank(message = "Имя пользователя обязательно")
    private String email;

    @Schema(description = "Роль пользователя",
            example = "PRE_APPLICATION",
            allowableValues = {"PRE_APPLICATION", "PROCESSING", "REFUSED", "ACCEPTED"})
    private Roles role;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime registrationDate;
}
