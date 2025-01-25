package dev.telegrambot.storage.web.dto.application;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.telegrambot.storage.domain.enums.ApplicationStatus;
import dev.telegrambot.storage.web.dto.course.CourseDto;
import dev.telegrambot.storage.web.dto.user.RegisteredUserDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class ApplicationChangingDto {

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd")
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
