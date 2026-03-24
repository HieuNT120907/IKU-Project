📦 NguyenTrungHieu_TH03575 Project
📌 Giới thiệu

NguyenTrungHieu_TH03575 Project là một dự án Spring Boot REST API được xây dựng nhằm mục đích học tập và thực hành phát triển hệ thống Backend theo chuẩn doanh nghiệp.

Dự án mô phỏng một hệ thống quản lý bán hàng đơn giản, cho phép quản lý:

👤 Người dùng (User)
🛒 Sản phẩm (SanPham)
📦 Đơn hàng (DonHang)

Hệ thống được thiết kế theo kiến trúc Layered Architecture (Controller – Service – Repository), đảm bảo:

Tách biệt rõ ràng giữa các tầng xử lý
Dễ mở rộng và bảo trì
Tuân thủ nguyên tắc Clean Code

Ngoài ra, hệ thống còn tích hợp:

🔐 Xác thực & phân quyền bằng JWT
📄 Swagger UI để test API
⚠️ Global Exception Handling
📋 Mô tả nghiệp vụ (Business Description)

Hệ thống phục vụ cho việc quản lý bán hàng cơ bản trong nội bộ doanh nghiệp hoặc cửa hàng nhỏ.

👤 User (Người dùng)

User là đối tượng sử dụng hệ thống.

Chức năng:
Đăng ký / đăng nhập hệ thống
Nhận JWT Token để truy cập API
Thực hiện các thao tác theo quyền (USER / ADMIN)
Thông tin cơ bản:
Username
Password (được mã hóa)
Role (USER / ADMIN)
🛒 Sản phẩm (SanPham)

SanPham đại diện cho hàng hóa trong hệ thống.

Chức năng:
Thêm / sửa / xóa sản phẩm
Quản lý tồn kho
Cung cấp dữ liệu cho đơn hàng
Thông tin:
Tên sản phẩm
Giá
Số lượng
Mô tả (nếu có)
📦 Đơn hàng (DonHang)

DonHang là thực thể trung tâm, đại diện cho giao dịch mua bán.

Chức năng:
Tạo đơn hàng
Gán sản phẩm vào đơn hàng
Gán user thực hiện đơn hàng
Cập nhật trạng thái đơn
🔗 Quan hệ nghiệp vụ
Một User có thể có nhiều Đơn hàng
Một Đơn hàng thuộc về một User
Một Đơn hàng có thể chứa nhiều Sản phẩm

👉 Đây là mô hình quan hệ phổ biến trong hệ thống thương mại.

🎯 Mục tiêu dự án

Dự án được xây dựng nhằm:

Hiểu rõ cách tổ chức project Spring Boot chuẩn
Áp dụng mô hình RESTful API
Tách lớp rõ ràng:
Controller → nhận request
Service → xử lý business logic
Repository → truy vấn database
Sử dụng DTO để tránh lộ Entity
Áp dụng Validation dữ liệu đầu vào
Xây dựng hệ thống xử lý lỗi tập trung
Tích hợp bảo mật với JWT
Làm quen với Swagger để test API
🛠 Công nghệ sử dụng
Công nghệ	Mô tả
Java 17	Ngôn ngữ chính
Spring Boot 3.x	Framework backend
Spring Data JPA	ORM
Hibernate	Mapping database
Spring Security	Bảo mật
JWT	Xác thực
Swagger (OpenAPI)	Test API
SQL Server	Database
Maven	Quản lý dependency
Postman	Test API
Git	Version control
📂 Cấu trúc project
src/main/java/com/example/nguyentrunghieu_th03575
│
├── config
│   ├── SecurityConfig.java
│   ├── SwaggerConfig.java
│
├── controller
│   ├── AuthController.java
│   ├── UserController.java
│   ├── SanPhamController.java
│   ├── DonHangController.java
│
├── dto
│   ├── request
│   └── response
│
├── entity
│   ├── User.java
│   ├── SanPham.java
│   ├── DonHang.java
│
├── enums
│   ├── Role.java
│
├── exception
│   ├── CustomException.java
│   ├── GlobalExceptionHandler.java
│
├── repository
│   ├── UserRepository.java
│   ├── SanPhamRepository.java
│   ├── DonHangRepository.java
│
├── security
│   ├── JwtFilter.java
│   ├── JwtUtil.java
│
├── service
│   ├── UserService.java
│   ├── SanPhamService.java
│   ├── DonHangService.java
│
└── validation
🚀 Chức năng đã hoàn thành
👤 User Module
CRUD User
Validate dữ liệu đầu vào
Mã hóa password bằng BCrypt
Phân quyền:
USER
ADMIN
Kiểm tra trùng username
🛒 SanPham Module
CRUD sản phẩm
Validate dữ liệu
Quản lý số lượng
📦 DonHang Module
CRUD đơn hàng
Gán User cho đơn hàng
Liên kết sản phẩm
Kiểm tra tồn tại dữ liệu trước khi tạo
🔐 Authentication & Authorization
Đăng nhập bằng JWT
Tạo token khi login thành công
Gửi token qua Header:
Authorization: Bearer <token>
Phân quyền truy cập API
Bảo vệ endpoint theo role
📮 API mẫu (Chi tiết)
🔐 Authentication API
Method	Endpoint	Mô tả
POST	/api/auth/login	Đăng nhập và trả về JWT
👤 User API
Method	Endpoint	Mô tả
GET	/api/users	Lấy danh sách
GET	/api/users/{id}	Lấy theo ID
POST	/api/users	Tạo user
PUT	/api/users/{id}	Cập nhật
DELETE	/api/users/{id}	Xóa
🛒 SanPham API
Method	Endpoint	Mô tả
GET	/api/sanpham	Lấy danh sách
POST	/api/sanpham	Tạo
PUT	/api/sanpham/{id}	Cập nhật
DELETE	/api/sanpham/{id}	Xóa
📦 DonHang API
Method	Endpoint	Mô tả
GET	/api/donhang	Lấy danh sách
POST	/api/donhang	Tạo
PUT	/api/donhang/{id}	Cập nhật
DELETE	/api/donhang/{id}	Xóa
📌 Quy ước API
Chuẩn RESTful
Dữ liệu JSON
Status Code:
Code	Ý nghĩa
200	Thành công
201	Tạo mới
400	Sai dữ liệu
401	Unauthorized
403	Forbidden
404	Not Found
409	Conflict
500	Server Error
⚠️ Xử lý Exception

Hệ thống sử dụng Global Exception Handler:

404 → Không tìm thấy dữ liệu
400 → Validate lỗi
409 → Trùng dữ liệu
500 → Lỗi server

Sử dụng:

@ControllerAdvice
⚙️ Cấu hình Database
SQL Server
Database: project_java
Port: 1433
CREATE DATABASE project_java;
🧠 Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
▶️ Hướng dẫn chạy Project
🔹 Cách 1: Chạy bằng IDE
Clone project:
git clone <repo>
Cấu hình database trong application.properties
Run:
NguyenTrungHieuTh03575Application.java
🔹 Cách 2: Build JAR
mvn clean package -DskipTests
java -jar target/*.jar
🧪 Test bằng Swagger

Truy cập:

http://localhost:8080/swagger-ui/index.html
Các bước:
Login lấy token
Bấm Authorize
Dán token
Test API
📅 Kế hoạch phát triển
Thêm Unit Test đầy đủ
Thêm Docker
Deploy server
Tối ưu performance
Thêm pagination API
👨‍💻 Thông tin sinh viên
Họ tên: Nguyễn Trung Hiếu
MSSV: TH03575
Định hướng: Backend Java Developer
Công nghệ: Spring Boot
