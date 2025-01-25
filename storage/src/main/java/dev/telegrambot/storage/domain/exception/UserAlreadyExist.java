package dev.telegrambot.storage.domain.exception;

import dev.telegrambot.storage.domain.user.User;

public class UserAlreadyExist extends RuntimeException {

    private final User user;

    public UserAlreadyExist(String message, User user) {
        super(message);
        this.user = user;
    }
}
