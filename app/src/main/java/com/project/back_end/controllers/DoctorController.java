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
    
    // PHƯƠNG THỨC 1: Lấy danh sách tất cả bác sĩ
    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        // Giả định DoctorService có phương thức findAllDoctors()
        List<Doctor> doctors = doctorService.findAllDoctors();
        return ResponseEntity.ok(doctors);
    }
    
    // PHƯƠNG THỨC 2: Truy xuất thời gian rảnh của bác sĩ
    // URL: /api/doctors/{id}/availability?date=YYYY-MM-DD
    @GetMapping("/{id}/availability")
    public ResponseEntity<List<String>> getDoctorAvailability(
            // Tham số doctorId từ URL path
            @PathVariable("id") Long doctorId,
            // Tham số date từ URL query string
            @RequestParam("date") LocalDate date) {
        
        // Gọi service để lấy thời gian rảnh theo ID bác sĩ và ngày
        List<String> availability = doctorService.getAvailability(doctorId, date);
        
        if (availability.isEmpty()) {
            // Trả về 404 nếu không có lịch trống
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(availability);
    }
    
    // Các phương thức khác (POST, PUT, DELETE) sẽ cần được thêm vào
}
