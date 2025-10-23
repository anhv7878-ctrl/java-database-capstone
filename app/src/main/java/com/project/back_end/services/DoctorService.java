package com.smartclinic.app.services;

import com.smartclinic.app.models.Doctor; 
import com.smartclinic.app.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
    // Có thể cần thêm AppointmentRepository để kiểm tra lịch trống
    // private final AppointmentRepository appointmentRepository; 

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
        // this.appointmentRepository = appointmentRepository;
    }

    // YÊU CẦU 1: Phương thức getDoctorById hoàn chỉnh
    public Optional<Doctor> getDoctorById(Long id) {
        // Logic truy vấn Doctor từ Repository
        return doctorRepository.findById(id);
    }

    // YÊU CẦU 2: Phương thức xác thực đăng nhập
    /**
     * Xác thực thông tin đăng nhập của bác sĩ.
     * @param email Email của bác sĩ.
     * @param password Mật khẩu thô (cần mã hóa trong thực tế).
     * @return Optional<Doctor> nếu xác thực thành công.
     */
    public Optional<Doctor> checkLoginCredentials(String email, String password) {
        // Trong thực tế, sẽ cần sử dụng PasswordEncoder để so sánh mật khẩu.
        // Đây là logic đơn giản hóa cho bài tập:
        return doctorRepository.findByEmail(email)
                .filter(doctor -> doctor.getPassword().equals(password));
    }
    
    // YÊU CẦU 3: Phương thức truy xuất lịch làm việc
    /**
     * Truy xuất thời gian rảnh (available time slots) của bác sĩ trong ngày.
     * @param doctorId ID của bác sĩ.
     * @param date Ngày cần kiểm tra lịch.
     * @return Danh sách các khung giờ còn trống.
     */
    public List<String> getAvailability(Long doctorId, LocalDate date) {
        // Logic nghiệp vụ phức tạp sẽ được đặt ở đây:
        // 1. Lấy tất cả cuộc hẹn đã lên lịch của bác sĩ trong ngày (dùng AppointmentRepository).
        // 2. So sánh với khung giờ làm việc cố định của bác sĩ.
        // 3. Trả về các khung giờ trống (Available Slots).
        
        // Trả về dữ liệu giả (mock data) để thể hiện chức năng:
        return List.of("09:00", "11:00", "14:30", "16:00"); 
    }
}
