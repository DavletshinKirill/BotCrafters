package com.example.telegramBot.service;

import com.example.telegramBot.feignclient.Microservice1Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelegramService {

    private final Microservice1Client microservice1Client;

    @Autowired
    public TelegramService(Microservice1Client microservice1Client) {
        this.microservice1Client = microservice1Client;
    }

    // Обработка сообщения с получением статуса
    public String handleMessage(String message, Long chatId) {
        if (message.equalsIgnoreCase("Статус базы данных")) {
            return microservice1Client.getDatabaseStatus();
        }
        return "Неизвестное сообщение";
    }

    // Новый метод для проверки состояния кнопок
    public String getButtonStatus() {
        return "Кнопки активны: " + (isApplicationOpen() ? "Да" : "Нет");
    }

    // Новый метод для отправки уведомлений
    public String sendNotificationsToAll(String message) {
        // Тут будет логика отправки уведомлений всем пользователям
        return "Уведомление отправлено: " + message;
    }

    // Логика для проверки статуса подачи заявки (можно перенести в ApplicationDateService)
    private boolean isApplicationOpen() {
        // Реализуем логику, которая будет использовать ApplicationDateService
        return true; // Пример
    }
}
