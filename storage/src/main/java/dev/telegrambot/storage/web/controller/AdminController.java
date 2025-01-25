package dev.telegrambot.storage.web.controller;

import dev.telegrambot.storage.domain.user.AdminUser;
import dev.telegrambot.storage.service.AdminService;
import dev.telegrambot.storage.web.dto.adminUser.AdminUserDto;
import dev.telegrambot.storage.web.mappers.adminUser.AdminUserMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/admin/admin_users")
@Tag(name = "AdminUsers", description = "Управление пользователями")
@Slf4j
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;
    private final AdminUserMapper adminUserMapper;

    @Operation(summary = "Создание нового администратора (только для администратора)")
    @PostMapping
    public AdminUserDto createAdminUser(@RequestBody @Valid AdminUserDto adminUserDto) {
        AdminUser adminUser = adminUserMapper.toEntity(adminUserDto);
        AdminUser createdApplication = adminService.crerateAdminUser(adminUser);
        return adminUserMapper.toDTO(createdApplication);
    }

    @Operation(summary = "Получение списка заявок пользователей")
    @GetMapping()
    public List<AdminUserDto> getAdminUsers(@RequestParam int offset, @RequestParam int limit) {
        List<AdminUser> adminUserList = adminService.getAdminUser(offset, limit);
        return adminUserMapper.toDTO(adminUserList);
    }

    @Operation(summary = "Обновление Username")
    @PatchMapping("/email/{adminUserId}")
    public AdminUserDto updateAdminUserByUsername(@PathVariable UUID adminUserId, @RequestBody String email) {
        AdminUser adminUser = adminService.updateAdminUserEmail(adminUserId, email);
        return adminUserMapper.toDTO(adminUser);
    }

    @Operation(summary = "Обновление Password")
    @PatchMapping("/password/{adminUserId}")
    public AdminUserDto updateAdminUserByPassword(@PathVariable UUID adminUserId, @RequestBody String password) {
        AdminUser adminUser = adminService.updateAdminUserPassword(adminUserId, password);
        return adminUserMapper.toDTO(adminUser);
    }
}
