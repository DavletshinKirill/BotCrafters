package com.example.telegramBot.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${jwt.secret}") // Секретный ключ для подписи токенов
    private String secretKeyString;

    @Value("${jwt.expiration}") // Время жизни токена (в миллисекундах)
    private long validityInMilliseconds;

    private Key secretKey; // Новый тип ключа для работы с JWT

    @PostConstruct
    public void init() {
        this.secretKey = Keys.hmacShaKeyFor(secretKeyString.getBytes()); // Создаем ключ на основе строки
    }

    // Генерация токена
    public String createToken(String username, String role) {
        Claims claims = Jwts.claims().setSubject(username).build();
        claims.put("role", role); // Добавляем роль в токен

        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(secretKey, SignatureAlgorithm.HS256) // Используем ключ и алгоритм
                .compact();
    }

    // Извлечение имени пользователя из токена
    public String getUsername(String token) {
        return getClaims(token).getSubject();
    }

    // Получение роли пользователя из токена
    public String getRole(String token) {
        return (String) getClaims(token).get("role");
    }

    // Проверка токена на валидность
    public boolean validateToken(String token) {
        try {
            return !getClaims(token).getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    private Claims getClaims(String token) {
        return Jwts.parser() // Создаем JwtParserBuilder
                .setSigningKey(secretKey) // Указываем ключ для верификации
                .build() // Строим парсер
                .parseClaimsJws(token) // Парсим токен
                .getBody(); // Возвращаем тело токена (Claims)
    }

}
