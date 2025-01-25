package com.example.telegramBot.bot;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

@Slf4j
@Service
@RequiredArgsConstructor
public class TelegramUpdateHandler {

    private final CommandProcessor commandProcessor;

    public void processUpdate(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();

            log.info("Received message: {} from chatId: {}", messageText, chatId);
            commandProcessor.processCommand(chatId, messageText);
        } else if (update.hasCallbackQuery()) {
            String callbackData = update.getCallbackQuery().getData();
            Long chatId = update.getCallbackQuery().getMessage().getChatId();

            log.info("Received callback: {} from chatId: {}", callbackData, chatId);
            commandProcessor.processCallback(chatId, callbackData);
        } else {
            log.warn("Unsupported update type: {}", update);
        }
    }
}
