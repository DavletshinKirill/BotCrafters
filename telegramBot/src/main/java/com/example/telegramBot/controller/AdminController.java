package com.example.telegramBot.controller;

import com.example.telegramBot.service.TelegramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin")
public class AdminController {

    private final TelegramService telegramService;

    @Autowired
    public AdminController(TelegramService telegramService) {
        this.telegramService = telegramService;
    }

    @GetMapping("/buttons-status")
    public String getButtonsStatus() {
        // Используем существующую логику из TelegramService
        return telegramService.handleMessage("Статус кнопок", null); // Мы просто отправляем запрос для получения статуса
    }

    @PostMapping("/notifications")
    public String sendNotifications(@RequestBody String message) {
        // Вызов существующего метода из TelegramService для рассылки уведомлений
        return telegramService.sendNotificationsToAll(message);
    }
}
