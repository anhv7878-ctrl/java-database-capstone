package com.smartclinic.app.repository;

import com.smartclinic.app.models.Patient; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional; 

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    
    // PHƯƠNG THỨC 1: Tìm bệnh nhân theo địa chỉ email (Đã có)
    Optional<Patient> findByEmail(String email);
    
    // PHƯƠNG THỨC 2: TÌM BỆNH NHÂN THEO EMAIL HOẶC SỐ ĐIỆN THOẠI (YÊU CẦU BỊ THIẾU)
    /**
     * Retrieves a patient entity by their email address OR phone number.
     * @param email The email address.
     * @param phoneNumber The phone number.
     * @return An Optional containing the found Patient or an empty Optional if none found.
     */
    Optional<Patient> findByEmailOrPhoneNumber(String email, String phoneNumber);
}
