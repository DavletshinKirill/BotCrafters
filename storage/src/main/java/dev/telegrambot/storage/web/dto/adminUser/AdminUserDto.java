package dev.telegrambot.storage.web.dto.adminUser;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema($schema = "Admin User DTO")
public class AdminUserDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UUID id;

    @NotBlank(message = "Имя пользователя обязательно")
    private String lastName;

    @NotBlank(message = "Фамилия пользователя обязательна")
    private String firstName;

    @NotBlank(message = "Имя пользователя обязательно")
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

}
