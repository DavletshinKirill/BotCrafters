package dev.telegrambot.storage.service.impl;

import dev.telegrambot.storage.domain.exception.ResourceAlreadyExist;
import dev.telegrambot.storage.domain.exception.ResourceNotFoundException;
import dev.telegrambot.storage.domain.user.AdminUser;
import dev.telegrambot.storage.repository.AdminUserRepository;
import dev.telegrambot.storage.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;


// TODO транзакции
@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminUserRepository adminUserRepository;

    @Transactional(readOnly = true)
    public AdminUser getAdminUser(UUID adminId) {
        return adminUserRepository.findById(adminId).orElseThrow(
                () -> new ResourceNotFoundException(String.format("AdminUser with id %s not found", adminId))
        );
    }

    @Override
    @Transactional
    public AdminUser updateAdminUserEmail(UUID uuid, String email) {
        AdminUser adminUser = getAdminUser(uuid);
        if (adminUserRepository.findByEmail(email).isEmpty()) {
            adminUser.setEmail(email);
            return adminUserRepository.save(adminUser);
        } else throw new ResourceAlreadyExist(String.format("AdminUser with email %s already exists", email));
    }

    @Override
    @Transactional
    public AdminUser updateAdminUserPassword(UUID uuid, String password) {
        AdminUser adminUser = getAdminUser(uuid);
        adminUser.setPassword(password);
        return adminUserRepository.save(adminUser);
    }

    @Override
    @Transactional
    public AdminUser crerateAdminUser(AdminUser adminUser) {
        return adminUserRepository.save(adminUser);
    }

    @Override
    @Transactional
    public List<AdminUser> getAdminUser(int offset, int limit) {
        Pageable pageable = PageRequest.of(offset, limit);
        Page<AdminUser> adminUserPage = adminUserRepository.findAll(pageable);
        return adminUserPage.hasContent() ? new ArrayList<>(adminUserPage.getContent()) : Collections.emptyList();
    }
}
