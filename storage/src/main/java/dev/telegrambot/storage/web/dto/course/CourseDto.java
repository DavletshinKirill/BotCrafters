package dev.telegrambot.storage.web.dto.course;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.telegrambot.storage.domain.enums.CourseStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

public class CourseDto {

    @NotNull(message = "Id must be not null.")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UUID id;

    @NotBlank(message = "Название курса обязательно")
    private String courseName;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Начало курса обязательно")
    private LocalDateTime startDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Конец курса обязателен")
    private LocalDateTime endDate;

    @Schema(description = "Статус курса",
            example = "OPENED",
            allowableValues = {"OPENED", "NOT_STARTED", "CLOSED"})
    private CourseStatus status;
}
