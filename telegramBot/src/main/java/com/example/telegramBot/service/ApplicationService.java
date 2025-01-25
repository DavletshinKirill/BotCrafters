package com.example.telegramBot.service;

import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

    @Counted(value = "loan.applications.submitted", description = "Number of submitted loan applications")
    public void submitApplication() {
        // Логика обработки заявки
    }

    @Counted(value = "loan.applications.pre.submitted", description = "Number of submitted pre-applications")
    public void submitPreApplication() {
        // Логика обработки предзаявки
    }

    @Timed(value = "button.status.time", description = "Time spent on button status request")
    public void checkButtonStatus() {
        // Логика запроса статуса кнопок
    }
}
