package dev.telegrambot.storage.service;

import dev.telegrambot.storage.domain.user.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    User createUser(User user);

    User getUserByEmail(String email);

    User getUserById(UUID id);

    List<User> getAllUsers(int offset, int limit);

}
