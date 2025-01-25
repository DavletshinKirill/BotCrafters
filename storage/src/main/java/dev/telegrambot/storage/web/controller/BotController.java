package dev.telegrambot.storage.web.controller;

import dev.telegrambot.storage.domain.user.User;
import dev.telegrambot.storage.service.BotService;
import dev.telegrambot.storage.service.CourseService;
import dev.telegrambot.storage.web.mappers.user.RegisteredUserMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bot")
@RequiredArgsConstructor
@Tag(name = "Bot Controller", description = "Bot Controller API")
@Slf4j
public class BotController {

    private final RegisteredUserMapper userMapper;
    private final BotService botService;
    private final CourseService courseService;

    @Operation(summary = "Create User", description = "Create 4 offers")
    @PostMapping("/{courseName}")
    public String createUser(@PathVariable String courseName, @RequestBody ChangingRegisteredUserDto userDto) {
        log.info(userDto.toString());
        User user = userMapper.toEntity(userDto);
        botService.createUser(user, courseName);
        // TODO Узнай, на что должна быть ссылка
        return "Some string with reference";
    }

    @Operation(summary = "Get All names", description = "Get All courses names")
    @GetMapping("courses")
    public List<String> getCourseNames() {
        return courseService.getAllCoursesTitle();
    }
}
