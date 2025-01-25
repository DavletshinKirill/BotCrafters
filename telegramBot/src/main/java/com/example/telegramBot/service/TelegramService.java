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

    public String handleMessage(String message, Long chatId) {
        // Пример логики обработки сообщения
        if (message.equalsIgnoreCase("Статус базы данных")) {
            return microservice1Client.getDatabaseStatus();  // Используем FeignClient
        }
        return "Неизвестное сообщение";
    }
}
