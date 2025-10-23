package com.smartclinic.app.controllers;

import com.smartclinic.app.models.Prescription;
import com.smartclinic.app.services.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid; // Tùy chọn: Thêm validation

@RestController
// Sửa đường dẫn để bao gồm token (theo yêu cầu bài tập)
@RequestMapping("/api/prescriptions/{token}") 
public class PrescriptionController {
    
    private final PrescriptionService prescriptionService;

    @Autowired
    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }
    
    // PHƯƠNG THỨC POST ĐÃ SỬA LỖI
    // Nhận token qua đường dẫn URL (@PathVariable)
    @PostMapping
    public ResponseEntity<Prescription> createPrescription(
            @PathVariable("token") String token, // THÊM: Token từ đường dẫn
            @Valid @RequestBody Prescription prescription) {
        
        // Ghi chú: Trong ứng dụng thực tế, token sẽ được xác thực ở đây hoặc ở lớp filter.
        // Ta chỉ cần đảm bảo nhận được tham số theo yêu cầu của bài tập.

        Prescription savedPrescription = prescriptionService.savePrescription(prescription);
        
        // Trả về đối tượng đã lưu với mã trạng thái 201 Created
        return new ResponseEntity<>(savedPrescription, HttpStatus.CREATED);
    }
    
    // Cần thêm các phương thức API khác
}
