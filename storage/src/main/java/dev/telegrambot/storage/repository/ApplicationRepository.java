package dev.telegrambot.storage.repository;

import dev.telegrambot.storage.domain.application.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApplicationRepository extends JpaRepository<Application, UUID> {
}
