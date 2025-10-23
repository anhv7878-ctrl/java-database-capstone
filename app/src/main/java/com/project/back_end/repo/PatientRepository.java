package com.smartclinic.app.repository;

import com.smartclinic.app.models.Patient; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional; // Cần import Optional để xử lý trường hợp không tìm thấy

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    
    // PHƯƠNG THỨC CẦN THIẾT: Tìm bệnh nhân theo địa chỉ email
    /**
     * Retrieves a patient entity by its email address.
     * Used for login or unique identification.
     * @param email The email address to search for.
     * @return An Optional containing the found Patient or an empty Optional if none found.
     */
    Optional<Patient> findByEmail(String email);

    // Có thể thêm các phương thức truy vấn tùy chỉnh khác ở đây
}
