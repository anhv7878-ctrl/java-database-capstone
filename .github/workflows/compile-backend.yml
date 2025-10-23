name: Java Backend Compilation

# Điều kiện kích hoạt workflow
on:
  push:
    branches: [ main ]
  pull_request:
    branches: [ main ]

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
    # Bước 1: Checkout mã nguồn
    - uses: actions/checkout@v4
    
    # Bước 2: Thiết lập Java
    - name: Set up JDK 17
      uses: actions/setup-java@v4
      with:
        java-version: '17'
        distribution: 'temurin'
        cache: maven 

    # Bước 3: Biên dịch và Đóng gói
    - name: Build with Maven Wrapper
      # SỬ DỤNG: ./mvnw package -DskipTests để gọi Maven Wrapper
      run: ./mvnw package -DskipTests
