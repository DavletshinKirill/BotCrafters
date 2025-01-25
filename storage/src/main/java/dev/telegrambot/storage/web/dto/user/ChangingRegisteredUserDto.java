package dev.telegrambot.storage.web.dto.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.telegrambot.storage.domain.enums.Roles;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ChangingRegisteredUserDto {

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
