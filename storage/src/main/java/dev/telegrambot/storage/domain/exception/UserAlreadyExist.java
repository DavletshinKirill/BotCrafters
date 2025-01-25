package dev.telegrambot.storage.domain.exception;

import dev.telegrambot.storage.domain.user.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserAlreadyExist extends RuntimeException {

    private User user;

    public UserAlreadyExist(String message, User user) {
        super(message);
        this.user = user;
    }
}
