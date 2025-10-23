package com.project.back_end.models;

import jakarta.persistence.Entity; // hoặc javax.persistence.Entity nếu dùng phiên bản cũ

@Entity
public class Doctor {

    private Long id;
    private String firstName;
    private String lastName;
    private String specialization;

    // Cần thêm constructors, getters, và setters ở phiên bản đầy đủ
}
