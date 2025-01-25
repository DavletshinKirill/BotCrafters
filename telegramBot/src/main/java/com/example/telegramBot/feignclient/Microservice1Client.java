package com.example.telegramBot.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "microservice1", url = "http://localhost:8081")  // Указать URL микросервиса 1
public interface Microservice1Client {

    @GetMapping("/api/status")  // Путь, по которому микросервис 1 возвращает статус базы данных
    String getDatabaseStatus();
}
