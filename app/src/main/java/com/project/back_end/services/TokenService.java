package com.smartclinic.app.services;

import org.springframework.stereotype.Service;

@Service
public class TokenService {
    // Phương thức tạo token
    public String generateToken(String username) {
        // Logic tạo token ở đây
        return "sample_token"; 
    }

    // Phương thức xác thực token
    public boolean validateToken(String token) {
        // Logic xác thực token
        return true;
    }
}
