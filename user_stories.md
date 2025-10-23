# User Stories for Smart Clinic Management System

## 1. Doctor User Stories

### US 1.1: Đăng nhập an toàn
**As a** Doctor, **I want to** log in securely using my credentials, **so that I can** access my private medical and appointment data.
* **Priority:** High
* **Acceptance Criteria:**
    * Hệ thống phải xác thực Doctor dựa trên Email/Username và Mật khẩu.
    * Hệ thống phải hiển thị thông báo lỗi rõ ràng nếu thông tin đăng nhập sai.
    * Sau khi đăng nhập thành công, Doctor phải được chuyển hướng đến Bảng điều khiển (Dashboard).
    * Phiên làm việc (session) phải được bảo mật bằng JWT hoặc cơ chế tương đương.

### US 1.2: Xem danh sách cuộc hẹn
**As a** Doctor, **I want to** view a list of all my scheduled appointments for a specific day, **so that I can** manage my time effectively.
* **Priority:** High
* **Acceptance Criteria:**
    * Danh sách phải hiển thị Tên Bệnh nhân, Thời gian bắt đầu và Lý do cuộc hẹn.
    * Doctor phải có khả năng lọc danh sách theo Ngày.
    * Doctor phải có khả năng nhấp vào một cuộc hẹn để xem chi tiết hồ sơ bệnh nhân.

// Thêm các US khác cho Doctor (ví dụ: Tạo/Cập nhật đơn thuốc, Xem lịch sử bệnh án)

---

## 2. Patient User Stories

### US 2.1: Đặt lịch hẹn mới
**As a** Patient, **I want to** book a new appointment with a chosen Doctor on an available date, **so that I can** nhận được sự chăm sóc y tế.
* **Priority:** High
* **Acceptance Criteria:**
    * Bệnh nhân phải có khả năng tìm kiếm Bác sĩ theo Chuyên môn hoặc Tên.
    * Hệ thống chỉ hiển thị các khung giờ còn trống (Available Slots) cho ngày đã chọn.
    * Sau khi đặt lịch, Bệnh nhân phải nhận được email xác nhận.

// Thêm các US khác cho Patient (ví dụ: Xem lịch sử khám bệnh, Hủy/Thay đổi lịch hẹn, Cập nhật hồ sơ)

---

## 3. Admin User Stories

### US 3.1: Thêm tài khoản Bác sĩ mới (Như yêu cầu Q16)
**As an** Admin, **I want to** easily add a new Doctor account to the system, **so that I can** mở rộng đội ngũ nhân viên.
* **Priority:** Medium
* **Acceptance Criteria:**
    * Admin phải điền các trường: Tên, Email, Mật khẩu, Chuyên môn và Số giấy phép.
    * Hệ thống phải xác thực tính duy nhất của Email và Số giấy phép.
    * Sau khi tạo, Doctor phải có khả năng đăng nhập ngay lập tức.

// Thêm các US khác cho Admin (ví dụ: Xem báo cáo phân tích, Quản lý dịch vụ phòng khám, Vô hiệu hóa tài khoản người dùng)
