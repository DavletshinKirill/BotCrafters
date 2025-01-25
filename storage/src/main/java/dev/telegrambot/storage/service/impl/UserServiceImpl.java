package dev.telegrambot.storage.service.impl;

import dev.telegrambot.storage.domain.exception.UserAlreadyExist;
import dev.telegrambot.storage.domain.exception.UserNotFoundException;
import dev.telegrambot.storage.domain.user.User;
import dev.telegrambot.storage.repository.UserRepository;
import dev.telegrambot.storage.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public User createUser(User user) {
        try {
            User savedUser = getUserByEmail(user.getEmail());
            throw new UserAlreadyExist(String.format("User with email: %s exist", user
                    .getEmail()), savedUser);
        } catch (UserNotFoundException e) {
            return userRepository.save(user);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(
                () -> new UserNotFoundException(String.format("User with email: %s doesn't exist", email))
        );
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(UUID id) {
        return userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException(String.format("User with id: %s doesn't exist", id))
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers(int offset, int limit) {
        Pageable pageable = PageRequest.of(offset, limit);
        Page<User> usersPage = userRepository.findAll(pageable);
        return usersPage.hasContent() ? new ArrayList<>(usersPage.getContent()) : Collections.emptyList();
    }
}
