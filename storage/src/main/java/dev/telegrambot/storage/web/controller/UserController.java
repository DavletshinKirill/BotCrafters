package dev.telegrambot.storage.web.controller;

import dev.telegrambot.storage.domain.user.User;
import dev.telegrambot.storage.service.UserService;
import dev.telegrambot.storage.web.dto.UserDto;
import dev.telegrambot.storage.web.mappers.UserMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/registered_users")
@Tag(name = "User Controller", description = "User Controller API")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @Operation(summary = "Get User", description = "Get User")
    @GetMapping("{user_id}")
    public UserDto getUser(UUID user_id) {
        User user = userService.getUserById(user_id);
        return userMapper.toDTO(user);
    }

    @Operation(summary = "Get Users", description = "Get Users")
    @GetMapping("{user_id}")
    public UserDto getUsers() {

    }


}
