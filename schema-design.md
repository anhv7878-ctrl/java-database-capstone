# MySQL Database Design for Smart Clinic Management System

-- 1. Bảng: Patients
CREATE TABLE Patients (
    patient_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    dob DATE,
    phone_number VARCHAR(15) UNIQUE,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL, -- Cần thiết cho login portal
    address VARCHAR(255)
);

-- 2. Bảng: Doctors
CREATE TABLE Doctors (
    doctor_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT UNIQUE, -- Có thể dùng để liên kết với bảng Users/Auth nếu có
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    specialization VARCHAR(100) NOT NULL,
    license_number VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL -- Cần thiết cho login portal
    -- ... các cột khác (ví dụ: phone, available_hours)
);

-- 3. Bảng: Appointments
CREATE TABLE Appointments (
    appointment_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT NOT NULL,
    doctor_id INT NOT NULL,
    appointment_date DATE NOT NULL,
    appointment_time TIME NOT NULL,
    reason TEXT,
    status ENUM('Scheduled', 'Completed', 'Cancelled') NOT NULL,
    
    FOREIGN KEY (patient_id) REFERENCES Patients(patient_id),
    FOREIGN KEY (doctor_id) REFERENCES Doctors(doctor_id)
);

-- 4. Bảng: Admins
CREATE TABLE Admins (
    admin_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
    -- ...
);

-- 5. Bảng: Medical_Records (Hồ sơ bệnh án)
CREATE TABLE Medical_Records (
    record_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT NOT NULL,
    doctor_id INT NOT NULL,
    appointment_id INT UNIQUE, -- Liên kết với một cuộc hẹn cụ thể
    diagnosis TEXT NOT NULL,
    treatment_notes TEXT,
    record_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    
    FOREIGN KEY (patient_id) REFERENCES Patients(patient_id),
    FOREIGN KEY (doctor_id) REFERENCES Doctors(doctor_id),
    FOREIGN KEY (appointment_id) REFERENCES Appointments(appointment_id)
);

-- 6. Bảng: Prescriptions (Đơn thuốc)
CREATE TABLE Prescriptions (
    prescription_id INT PRIMARY KEY AUTO_INCREMENT,
    record_id INT NOT NULL, -- Liên kết với hồ sơ bệnh án
    drug_name VARCHAR(100) NOT NULL,
    dosage VARCHAR(50),
    frequency VARCHAR(50),
    duration VARCHAR(50),
    issued_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    
    FOREIGN KEY (record_id) REFERENCES Medical_Records(record_id)
);
