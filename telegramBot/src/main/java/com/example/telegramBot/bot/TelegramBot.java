package com.example.telegramBot.bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    private final String botToken;
    private final String botUsername;
    private final TelegramUpdateHandler telegramUpdateHandler;

    @Autowired
    public TelegramBot(String botToken, String botUsername, TelegramUpdateHandler telegramUpdateHandler) {
        this.botToken = botToken;
        this.botUsername = botUsername;
        this.telegramUpdateHandler = telegramUpdateHandler;
    }


    @Override
    public void onUpdateReceived(Update update) {
        telegramUpdateHandler.processUpdate(update);  // Используем TelegramUpdateHandler для обработки обновлений
    }

    public void sendResponse(Long chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();  // Можно улучшить обработку ошибок
        }
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }
}

