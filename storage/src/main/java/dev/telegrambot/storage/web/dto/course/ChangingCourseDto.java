package dev.telegrambot.storage.web.dto.course;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.telegrambot.storage.domain.enums.CourseStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

public class ChangingCourseDto {


    @NotBlank(message = "Название курса обязательно")
    private String name;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime startDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime endDate;

    @Schema(description = "Статус курса",
            example = "OPENED",
            allowableValues = {"OPENED", "NOT_STARTED", "CLOSED"})
    private CourseStatus status;
}
