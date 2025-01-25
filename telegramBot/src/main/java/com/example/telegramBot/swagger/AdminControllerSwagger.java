package com.example.telegramBot.swagger;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Admin Controller", description = "Контроллер для администраторов для работы с кнопками и уведомлениями")
public interface AdminControllerSwagger {

    @Operation(summary = "Получить статус кнопок", description = "Возвращает статус кнопок для подачи заявки или предзаявки.")
    @ApiResponse(responseCode = "200", description = "Статус кнопок успешно получен")
    String getButtonsStatus();

    @Operation(summary = "Отправка уведомлений", description = "Отправка уведомлений всем пользователям.")
    @ApiResponse(responseCode = "200", description = "Уведомления успешно отправлены")
    String sendNotifications(String message);
}
