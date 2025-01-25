package dev.telegrambot.storage.web.controller;

import dev.telegrambot.storage.domain.application.Application;
import dev.telegrambot.storage.domain.enums.ApplicationStatus;
import dev.telegrambot.storage.service.ApplicationService;
import dev.telegrambot.storage.web.dto.application.ApplicationDto;
import dev.telegrambot.storage.web.mappers.application.ApplicationMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/applications")
@Slf4j
@Tag(name = "Applications", description = "Управление Заявками")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;
    private final ApplicationMapper applicationMapper;

    @Operation(summary = "Получение информации о заявке")
    @GetMapping("{application_id}")
    public ApplicationDto getApplication(UUID application_id) {
        Application application = applicationService.getApplication(application_id);
        return applicationMapper.toDTO(application);
    }

    @Operation(summary = "Получение списка заявок пользователей")
    @GetMapping()
    public List<ApplicationDto> getApplications(@RequestParam int offset, @RequestParam int limit) {
        List<Application> applications = applicationService.getApplications(offset, limit);
        return applicationMapper.toDTO(applications);
    }

    @Operation(summary = "Обновление статуса заявки (только для администратора)")
    @PatchMapping("{application_id}")
    public ApplicationDto updateApplication(@RequestBody ApplicationStatus applicationStatus, @PathVariable UUID application_id) {
        Application updatedApplication = applicationService.updateApplicationStatus(application_id, applicationStatus);
        return applicationMapper.toDTO(updatedApplication);
    }

    @Operation(summary = "Создание новой заявки")
    @PostMapping
    public ApplicationDto createApplication(@RequestBody @Valid ApplicationDto applicationChangingDto) {
        Application application = applicationMapper.toEntity(applicationChangingDto);
        Application createdApplication = applicationService.createApplication(application);
        return applicationMapper.toDTO(createdApplication);
    }
}
