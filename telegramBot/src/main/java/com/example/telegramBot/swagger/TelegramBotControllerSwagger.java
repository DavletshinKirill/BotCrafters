package com.example.telegramBot.swagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Telegram Bot Controller", description = "Контроллер для работы с заявками и предзаявками через Telegram Bot")
public interface TelegramBotControllerSwagger {

    @Operation(summary = "Подать заявку", description = "Метод для подачи заявки пользователем, если заявки открыты.")
    @ApiResponse(responseCode = "200", description = "Заявка успешно подана")
    @ApiResponse(responseCode = "400", description = "Заявки закрыты")
    String submitApplication(String userId);

    @Operation(summary = "Оставить предзаявку", description = "Метод для оставления предзаявки, если заявки закрыты.")
    @ApiResponse(responseCode = "200", description = "Предзаявка успешно оставлена")
    @ApiResponse(responseCode = "400", description = "Можно подать заявку прямо сейчас")
    String submitPreApplication(String userId);
}
