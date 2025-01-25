package dev.telegrambot.storage.web.controller;

import dev.telegrambot.storage.domain.user.User;
import dev.telegrambot.storage.service.UserService;
import dev.telegrambot.storage.web.dto.user.ChangingRegisteredUserDto;
import dev.telegrambot.storage.web.dto.user.RegisteredUserDto;
import dev.telegrambot.storage.web.mappers.user.ChangingRegisteredMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/registered_users")
@Tag(name = "Users", description = "Управление пользователями")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ChangingRegisteredMapper userMapper;

    @Operation(summary = "Get User", description = "Get User")
    @GetMapping("{user_id}")
    public RegisteredUserDto getUser(UUID user_id) {
        User user = userService.getUserById(user_id);
        return userMapper.toDTO(user);
    }

    @Operation(summary = "Get Users", description = "Get Users")
    @GetMapping()
    public List<ChangingRegisteredUserDto> getUsers(@RequestParam int offset, @RequestParam int limit) {
        List<User> user = userService.getAllUsers(offset, limit);
        return userMapper.toDTO(user);
    }

    @Operation(summary = "updateUser", description = "Update User")
    @PutMapping
    public ChangingRegisteredUserDto updateUser(@RequestBody @Valid ChangingRegisteredUserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User updateUser = userService.createUser(user);
        return userMapper.toDTO(updateUser);
    };

    @Operation(summary = "createUser", description = "Create User")
    @PostMapping
    public ChangingRegisteredUserDto createUser(@RequestBody @Valid ChangingRegisteredUserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User createdUser = userService.createUser(user);
        return userMapper.toDTO(createdUser);
    }


}
