package com.smartclinic.app.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Doctor {

    // THÊM: @Id và @GeneratedValue
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String firstName;
    private String lastName;
    private String specialization;
    private String licenseNumber;
    private String email;
    private String password; // Trong thực tế, cần xử lý bảo mật cho mật khẩu

    // THÊM: Constructor mặc định (cần thiết cho JPA)
    public Doctor() {
    }

    // THÊM: Constructor có tham số (tùy chọn nhưng hữu ích)
    public Doctor(String firstName, String lastName, String specialization, String licenseNumber, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
        this.licenseNumber = licenseNumber;
        this.email = email;
        this.password = password;
    }
    
    // THÊM: Getters and Setters cho tất cả các trường
    // (Bạn nên thêm đầy đủ các phương thức này ở đây)
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    // ... các getters/setters khác ...
    
    public String getFirstName() {
        return firstName;
    }
    // ...
}
