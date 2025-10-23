package com.smartclinic.app.controllers;

import com.smartclinic.app.models.Doctor;
import com.smartclinic.app.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
    
    // PHƯƠNG THỨC 1: Lấy danh sách tất cả bác sĩ (Ví dụ cho chức năng tìm kiếm)
    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        // Gọi service để lấy dữ liệu.
        List<Doctor> doctors = doctorService.findAllDoctors();
        return ResponseEntity.ok(doctors);
    }
    
    // PHƯƠNG THỨC 2: Truy xuất thời gian rảnh của bác sĩ (YÊU CẦU CRITICAL)
    @GetMapping("/{id}/availability")
    public ResponseEntity<List<String>> getDoctorAvailability(
            @PathVariable Long id,
            @RequestParam LocalDate date) {
        
        // Gọi service để lấy thời gian rảnh theo ID bác sĩ và ngày
        List<String> availability = doctorService.getAvailability(id, date);
        
        if (availability.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(availability);
    }
    
    // Cần thêm các phương thức POST (tạo), PUT (cập nhật), DELETE (xóa) cho quản trị viên
}
