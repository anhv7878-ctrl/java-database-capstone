package com.smartclinic.app.services;

import org.springframework.stereotype.Service;
import com.smartclinic.app.models.Doctor; // Giả sử đã tạo

@Service
public class DoctorService {

    // Cần thêm logic nghiệp vụ, ví dụ:
    public Doctor getDoctorById(Long id) {
        // Logic truy vấn Doctor từ Repository
        return null;
    }

    public void updateDoctorProfile(Doctor doctor) {
        // Logic cập nhật thông tin Doctor
    }
}
