package com.example.telegramBot.service;

import com.example.telegramBot.feignclient.Microservice1Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ApplicationDateService {

    private final Microservice1Client microservice1Client;

    @Autowired
    public ApplicationDateService(Microservice1Client microservice1Client) {
        this.microservice1Client = microservice1Client;
    }

    public boolean isApplicationOpen() {
        String status = microservice1Client.getDatabaseStatus();  // Получаем статус от микросервиса №1
        return "open".equalsIgnoreCase(status);  // Проверяем, открыт ли набор
    }
}
