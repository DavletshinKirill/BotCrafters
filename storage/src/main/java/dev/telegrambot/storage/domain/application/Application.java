package dev.telegrambot.storage.domain.application;

import dev.telegrambot.storage.domain.course.Course;
import dev.telegrambot.storage.domain.enums.ApplicationStatus;
import dev.telegrambot.storage.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Entity
@Table(name = "applications")
@Data
@NoArgsConstructor
@Builder
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    private User user;

    @ManyToOne
    private Course course;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;

}
