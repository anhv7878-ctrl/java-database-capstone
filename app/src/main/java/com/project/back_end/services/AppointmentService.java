package com.smartclinic.app.services;

import com.smartclinic.app.models.Appointment;
import com.smartclinic.app.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository; 

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    // YÊU CẦU 1 & 2: Phương thức đặt lịch hoàn chỉnh
    /**
     * Thực hiện logic nghiệp vụ và lưu cuộc hẹn mới.
     * @param appointment Đối tượng cuộc hẹn cần lưu.
     * @return Đối tượng Appointment đã được lưu.
     */
    public Appointment bookAppointment(Appointment appointment) {
        // Trong thực tế, cần thêm logic kiểm tra trùng lịch (availability check) trước khi lưu.
        
        // Logic chính: Gọi Repository để lưu đối tượng
        return appointmentRepository.save(appointment);
    }
    
    // YÊU CẦU 3: Phương thức truy xuất theo Bác sĩ và Ngày
    /**
     * Truy xuất danh sách cuộc hẹn của một bác sĩ vào một ngày cụ thể.
     * @param doctorId ID của bác sĩ.
     * @param date Ngày cần truy vấn.
     * @return Danh sách các cuộc hẹn.
     */
    public List<Appointment> getAppointmentsByDoctorAndDate(Long doctorId, LocalDate date) {
        // Phương thức này sẽ dựa vào một phương thức findByDoctorIdAndAppointmentDate trong AppointmentRepository
        // Bạn cần đảm bảo đã tạo phương thức đó trong Repository.
        return appointmentRepository.findByDoctorIdAndAppointmentDate(doctorId, date);
    }
}
