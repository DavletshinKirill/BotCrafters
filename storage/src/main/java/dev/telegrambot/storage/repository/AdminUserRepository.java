package dev.telegrambot.storage.repository;

import dev.telegrambot.storage.domain.user.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdminUserRepository extends JpaRepository<AdminUser, UUID> {
}
