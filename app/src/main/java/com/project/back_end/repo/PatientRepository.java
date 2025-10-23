package com.smartclinic.app.repository;

import com.smartclinic.app.models.Patient; // Giả sử bạn đã tạo Patient.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    // Có thể thêm các phương thức truy vấn tùy chỉnh ở đây
}
