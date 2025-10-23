package com.smartclinic.app.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class TokenService {

    // 1. Tạo Khóa ký (Signing Key) tĩnh cho mục đích demo/kiểm thử
    // TRONG THỰC TẾ, NÊN ĐỌC KHÓA NÀY TỪ application.properties/YML
    private static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final long EXPIRATION_TIME = TimeUnit.HOURS.toMillis(1); // 1 giờ

    /**
     * Tạo JWT Token với IssuedAt và Expiration Time.
     * Yêu cầu: Sử dụng Jwts.builder(), issuedAt và expiration.
     */
    public String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);

        return Jwts.builder()
                // Thông tin cần đưa vào token (claims)
                .setSubject(username) // Ai là chủ thể của token
                .setIssuedAt(now)     // THÊM: Thời gian tạo (IssuedAt)
                .setExpiration(expiryDate) // THÊM: Thời gian hết hạn (Expiration)
                
                // Ký token bằng thuật toán và khóa bí mật
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256) 
                .compact();
    }

    /**
     * Xác thực token. Cần thiết cho bảo mật.
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY) // Sử dụng khóa bí mật để kiểm tra chữ ký
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            // Log lỗi: Token không hợp lệ, hết hạn, hoặc chữ ký sai
            return false;
        }
    }
}
