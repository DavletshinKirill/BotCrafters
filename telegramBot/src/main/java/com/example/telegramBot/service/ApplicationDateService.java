package com.example.telegramBot.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ApplicationDateService {

    // Примерные даты набора
    private final LocalDate startDate = LocalDate.of(2025, 1, 1);
    private final LocalDate endDate = LocalDate.of(2025, 2, 31);

    public boolean isApplicationOpen() {
        LocalDate currentDate = LocalDate.now();
        return !currentDate.isBefore(startDate) && !currentDate.isAfter(endDate);
    }
}
