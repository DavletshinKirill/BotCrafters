package dev.telegrambot.storage.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@Entity
@Table(name = "admin_users")
@Data
@NoArgsConstructor
public class AdminUser {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "name")
    private String name;


    @Column(name = "password")
    private String password;
}
