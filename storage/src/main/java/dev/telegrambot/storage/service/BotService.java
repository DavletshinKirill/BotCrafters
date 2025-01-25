package dev.telegrambot.storage.service;

import dev.telegrambot.storage.domain.user.User;

public interface BotService {
    void createUser(User user, String courseName);
}
