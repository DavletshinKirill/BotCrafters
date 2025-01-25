package com.example.telegramBot.config;


import com.example.telegramBot.bot.TelegramBot;
import com.example.telegramBot.bot.TelegramUpdateHandler;
import com.example.telegramBot.service.TelegramService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.generics.LongPollingBot;

@Configuration
public class TelegramBotConfig {

    @Value("${telegram.bot.token}")
    private String botToken;

    @Value("${telegram.bot.username}")
    private String botUsername;

    @Bean
    public LongPollingBot telegramBots(TelegramUpdateHandler telegramUpdateHandler) {
        return new TelegramBot(botToken, botUsername, telegramUpdateHandler);
    }
}

