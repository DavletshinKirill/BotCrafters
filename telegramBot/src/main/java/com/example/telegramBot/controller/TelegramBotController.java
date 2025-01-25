package com.example.telegramBot.controller;

import com.example.telegramBot.service.ApplicationDateService;
import com.example.telegramBot.service.TelegramService;
import com.example.telegramBot.swagger.TelegramBotControllerSwagger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class TelegramBotController implements TelegramBotControllerSwagger {

    private final ApplicationDateService applicationDateService;
    private final TelegramService telegramService;

    @Autowired
    public TelegramBotController(ApplicationDateService applicationDateService, TelegramService telegramService) {
        this.applicationDateService = applicationDateService;
        this.telegramService = telegramService;
    }

    @Override
    @PostMapping("/submit-application")
    public String submitApplication(@RequestParam String userId) {
        if (applicationDateService.isApplicationOpen()) {
            // Логика подачи заявки
            return "Заявка успешно подана";
        } else {
            return "Заявки закрыты. Вы можете оставить предзаявку.";
        }
    }

    @Override
    @PostMapping("/submit-pre-application")
    public String submitPreApplication(@RequestParam String userId) {
        if (!applicationDateService.isApplicationOpen()) {
            // Логика предзаявки
            return "Предзаявка успешно оставлена";
        } else {
            return "Вы можете подать заявку прямо сейчас.";
        }
    }
}
