package dev.telegrambot.storage.repository;

import dev.telegrambot.storage.domain.user.AdminUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AdminUserRepository extends JpaRepository<AdminUser, UUID> {
    Page<AdminUser> findAll(Pageable pageable);

    Optional<AdminUser> findByEmail(String email);
}
