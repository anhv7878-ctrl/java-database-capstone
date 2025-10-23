package com.smartclinic.app.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // THÊM Validation: @NotNull và @Future
    @NotNull(message = "Appointment time cannot be null")
    @Future(message = "Appointment time must be in the future")
    private LocalDateTime appointmentTime;
    
    private String status = "SCHEDULED";

    // THÊM Mối quan hệ: ManyToOne với Doctor
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    // THÊM Mối quan hệ: ManyToOne với Patient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;
    
    private String reason;
    
    // Constructors (Mặc định và có tham số)
    public Appointment() { }

    public Appointment(LocalDateTime appointmentTime, Doctor doctor, Patient patient, String reason) {
        this.appointmentTime = appointmentTime;
        this.status = "SCHEDULED";
        this.doctor = doctor;
        this.patient = patient;
        this.reason = reason;
    }

    // Getters and Setters (Chỉ liệt kê một vài ví dụ, bạn cần thêm đầy đủ)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getAppointmentTime() { return appointmentTime; }
    public void setAppointmentTime(LocalDateTime appointmentTime) { this.appointmentTime = appointmentTime; }
    
    public Doctor getDoctor() { return doctor; }
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }
    
    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
}
