package com.example.telegramBot.bot;

import com.example.telegramBot.service.TelegramService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CommandProcessor {

    private final TelegramService telegramService;

    @Autowired
    public CommandProcessor(TelegramService telegramService) {
        this.telegramService = telegramService;
    }

    public void processCommand(Long chatId, String command) {
        log.info("Processing command: {} for chatId: {}", command, chatId);

        switch (command) {
            case "/start" -> handleStartCommand(chatId);
            case "/help" -> handleHelpCommand(chatId);
            case "/status" -> handleStatusCommand(chatId);  // Новый обработчик команды
            default -> handleUnknownCommand(chatId);
        }
    }

    private void handleStatusCommand(Long chatId) {
        // Вызов метода из TelegramService для получения статуса базы данных
        String status = telegramService.handleMessage("Статус базы данных", chatId);
        log.info("Sending status to chatId: {}", chatId);
        // Здесь отправка полученного статус обратно пользователю
    }

    public void processCallback(Long chatId, String callbackData) {
        log.info("Processing callback: {} for chatId: {}", callbackData, chatId);
        // Обработка callback-данных
    }

    private void handleStartCommand(Long chatId) {
        // Отправка приветственного сообщения
        log.info("Sending start message to chatId: {}", chatId);
    }

    private void handleHelpCommand(Long chatId) {
        // Отправка информации о командах
        log.info("Sending help message to chatId: {}", chatId);
    }

    private void handleUnknownCommand(Long chatId) {
        // Обработка неизвестной команды
        log.info("Sending unknown command message to chatId: {}", chatId);
    }
}
