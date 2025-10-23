# ====================================================================
# GIAI ĐOẠN 1: XÂY DỰNG ỨNG DỤNG (BUILD STAGE)
# Sử dụng JDK 17 cho việc biên dịch và đóng gói
# ====================================================================
FROM openjdk:17-jdk-slim AS builder

# Đặt thư mục làm việc bên trong container
WORKDIR /app

# Sao chép các tệp cấu hình Maven và mã nguồn
# Tối ưu hóa Docker layer caching: sao chép cấu hình trước, sau đó là mã nguồn
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn
COPY src src

# Chạy Maven để đóng gói ứng dụng
# -DskipTests: Bỏ qua kiểm thử (phổ biến trong môi trường build CI/CD)
# -Dmaven.clean.skip=true: Chỉ cần package, không cần clean
RUN ./mvnw package -DskipTests -Dmaven.clean.skip=true

# ====================================================================
# GIAI ĐOẠN 2: CHẠY ỨNG DỤNG (RUN STAGE)
# Sử dụng JRE (Java Runtime Environment) nhẹ hơn cho môi trường sản xuất
# ====================================================================
FROM openjdk:17-jre-slim # CHỈ DÙNG JRE, NHẸ HƠN JDK
WORKDIR /app

# Sao chép JAR đã được đóng gói từ giai đoạn 'builder'
# jar_file_name.jar cần được thay bằng tên JAR thực tế của bạn
# Ví dụ: java-database-capstone-0.0.1-SNAPSHOT.jar
COPY --from=builder /app/target/*.jar app.jar

# Mở cổng mặc định của ứng dụng Spring Boot
EXPOSE 8080

# Điểm vào để chạy ứng dụng
ENTRYPOINT ["java", "-jar", "app.jar"]

# Bạn có thể thêm lệnh HEALTHCHECK ở đây để cải thiện tính năng container
