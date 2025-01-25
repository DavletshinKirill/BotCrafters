package dev.telegrambot.storage.service;

import dev.telegrambot.storage.domain.user.AdminUser;

import java.util.List;
import java.util.UUID;

public interface AdminService {
    AdminUser updateAdminUserEmail(UUID uuid, String email);

    AdminUser updateAdminUserPassword(UUID uuid, String password);

    AdminUser crerateAdminUser(AdminUser adminUser);

    List<AdminUser> getAdminUser(int offset, int limit);
}
