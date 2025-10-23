package com.project.back_end.models;

import java.time.LocalDateTime;
import jakarta.persistence.Entity; 

@Entity
public class Appointment {

    private Long id;
    private LocalDateTime appointmentTime;
    private String status;
    private Long patientId; // Cần thiết lập quan hệ thực tế
    private Long doctorId; // Cần thiết lập quan hệ thực tế

    // Cần thêm constructors, getters, và setters ở phiên bản đầy đủ
}
