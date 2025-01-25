package dev.telegrambot.storage.web.dto.application;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import dev.telegrambot.storage.domain.enums.ApplicationStatus;
import dev.telegrambot.storage.web.dto.course.CourseDto;
import dev.telegrambot.storage.web.dto.user.RegisteredUserDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema($schema = "Application DTO")
public class ApplicationDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @NotNull(message = "Id must be not null.")
    private UUID id;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createdAt;

    @NotNull(message = "Пользователь обязателен")
    private RegisteredUserDto user;

    @NotNull(message = "Курс обязателен")
    private CourseDto course;

    @Schema(description = "Статус заявки",
            example = "PRE_APPLICATION",
            allowableValues = {"PRE_APPLICATION", "PROCESSING", "REFUSED", "ACCEPTED"})
    private ApplicationStatus status;
}
