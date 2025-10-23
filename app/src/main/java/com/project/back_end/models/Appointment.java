package com.smartclinic.app.models;

import jakarta.persistence.*; // Nhập tất cả các JPA annotations
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments") // Tùy chọn: Đặt tên bảng rõ ràng
public class Appointment {

    // 1. Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime appointmentTime;
    private String status;

    // 2. MỐI QUAN HỆ CẦN THIẾT: Many-to-One với Doctor
    // Mỗi cuộc hẹn thuộc về MỘT bác sĩ
    @ManyToOne(fetch = FetchType.LAZY) // LAZY: chỉ tải khi cần thiết
    @JoinColumn(name = "doctor_id", nullable = false) // Khoá ngoại
    private Doctor doctor;

    // 3. MỐI QUAN HỆ CẦN THIẾT: Many-to-One với Patient
    // Mỗi cuộc hẹn thuộc về MỘT bệnh nhân
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;
    
    // Thêm các trường khác nếu cần thiết (ví dụ: Lý do, Ghi chú)
    private String reason;
    
    // 4. Constructors (Cần thiết cho JPA)
    public Appointment() {
    }

    // Constructor hữu ích để tạo cuộc hẹn
    public Appointment(LocalDateTime appointmentTime, Doctor doctor, Patient patient, String reason) {
        this.appointmentTime = appointmentTime;
        this.status = "SCHEDULED"; // Mặc định là đã lên lịch
        this.doctor = doctor;
        this.patient = patient;
        this.reason = reason;
    }

    // 5. Getters and Setters (Bạn phải thêm đầy đủ các phương thức này)
    
    public Long getId() {
        return id;
    }
    
    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
    
    // ... các getters/setters khác cho Doctor, Patient, status, v.v. ...
    
    public Doctor getDoctor() {
        return doctor;
    }
    
    public Patient getPatient() {
        return patient;
    }
}
