package com.example.telegramBot.controller;

import com.example.telegramBot.service.ApplicationDateService;
import com.example.telegramBot.swagger.ButtonControllerSwagger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/buttons")
public class ButtonController implements ButtonControllerSwagger {

    private final ApplicationDateService applicationDateService;

    @Autowired
    public ButtonController(ApplicationDateService applicationDateService) {
        this.applicationDateService = applicationDateService;
    }

    @Override
    @GetMapping("/status")
    public String getApplicationStatus() {
        if (applicationDateService.isApplicationOpen()) {
            return "Подать заявку";
        } else {
            return "Оставить предзаявку";
        }
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
