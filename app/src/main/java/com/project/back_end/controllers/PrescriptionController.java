package com/smartclinic/app/controllers;

import com.smartclinic.app.models.Prescription;
import com.smartclinic.app.services.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {
    
    // 1. Khai báo và Tiêm (Inject) Service
    private final PrescriptionService prescriptionService;

    @Autowired
    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }
    
    // 2. PHƯƠNG THỨC POST CẦN THIẾT
    @PostMapping
    public ResponseEntity<Prescription> createPrescription(@RequestBody Prescription prescription) {
        // Lưu đơn thuốc mới thông qua tầng Service
        Prescription savedPrescription = prescriptionService.savePrescription(prescription);
        
        // Trả về đối tượng đã lưu với mã trạng thái 201 Created
        return new ResponseEntity<>(savedPrescription, HttpStatus.CREATED);
    }

    // Cần thêm các phương thức API khác như GET by ID, GET All, v.v.
}
