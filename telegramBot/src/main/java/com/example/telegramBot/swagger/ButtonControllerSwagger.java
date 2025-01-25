package com.example.telegramBot.swagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Button Controller", description = "Контроллер для работы с кнопками для подачи заявки и предзаявки")
public interface ButtonControllerSwagger {

    @Operation(summary = "Получить статус кнопки подачи заявки", description = "Возвращает текст кнопки, которая либо позволяет подать заявку, либо оставит предзаявку в зависимости от даты.")
    @ApiResponse(responseCode = "200", description = "Статус кнопки успешно получен")
    String getApplicationStatus();

    @Operation(summary = "Подать заявку", description = "Подача заявки. Возвращает сообщение о статусе подачи заявки.")
    @ApiResponse(responseCode = "200", description = "Заявка успешно подана")
    @ApiResponse(responseCode = "400", description = "Заявки закрыты")
    String submitApplication(String userId);

    @Operation(summary = "Оставить предзаявку", description = "Оставить предзаявку, если заявка закрыта.")
    @ApiResponse(responseCode = "200", description = "Предзаявка успешно оставлена")
    String submitPreApplication(String userId);
}
