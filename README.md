Iku Project

📌 Giới thiệu
Iku Project là một dự án Spring Boot REST API được xây dựng trong quá trình thực tập Backend Java.
Dự án tập trung vào việc quản lý User – Project – Task, áp dụng kiến trúc RESTful API chuẩn, tách lớp rõ ràng và xử lý exception tập trung.

📋 Mô tả nghiệp vụ (Business Description)
Hệ thống Iku Project là hệ thống quản lý công việc nội bộ, hỗ trợ quản lý người dùng (User), dự án (Project) và công việc (Task).

👤 User
User là người sử dụng hệ thống, có thể tham gia nhiều Project và được gán nhiều Task.

📌 Project
Project đại diện cho một dự án cụ thể.
Mỗi Project bao gồm nhiều Task và có trạng thái: PLANNING, IN_PROGRESS, DONE.

📝 Task
Task là đơn vị công việc nhỏ nhất trong hệ thống.

Mỗi Task:
Thuộc về một Project
Được gán cho một User
Có trạng thái: TODO, IN_PROGRESS, DONE

🔗 Quan hệ nghiệp vụ
Một User có thể được gán nhiều Task
Một Project có thể chứa nhiều Task
Mỗi Task chỉ thuộc về một User và một Project tại một thời điểm

Hệ thống hỗ trợ:
Quản lý User
Quản lý Project
Quản lý Task
Theo dõi trạng thái công việc

🎯 Mục tiêu
Làm quen với cấu trúc project Spring Boot chuẩn
Xây dựng REST API theo mô hình Controller – Service – Repository
Áp dụng DTO, Validation, Exception Handling
Thực hành bảo mật với Spring Security & JWT
Triển khai tài liệu API với Swagger UI

🛠 Công nghệ sử dụng
Java 17
Spring Boot 3.x
Spring Data JPA & Hibernate
Spring Security & JWT (JSON Web Token)
Springdoc OpenAPI (Swagger UI)
Database: SQL Server

Thư viện hỗ trợ:
ModelMapper
Lombok
Hibernate Validator

Công cụ:
Maven
Git & GitHub

📂 Cấu trúc project
src/main/java/com/example/projectiku

config # Cấu hình Security, Swagger, ModelMapper
controller # Xử lý request/response API
dto # Request / Response DTO
entity # Entity (User, Project, Task)
enums # Enum trạng thái
exception # Custom Exception & Global Handler
repository # JPA Repository
security # JWT Filter và Authentication
service # Business logic

🚀 Chức năng đã hoàn thành

🔐 Authentication & Authorization
Đăng ký & đăng nhập
Xác thực bằng JWT
Phân quyền USER / MANAGER
Bảo vệ API theo role
Xử lý lỗi 401, 403

👤 User Module
CRUD User
Validate dữ liệu
Kiểm tra trùng username, email
Mã hóa mật khẩu BCrypt

📌 Project Module
CRUD Project
Quản lý trạng thái
Quan hệ 1-N với Task

📝 Task Module
CRUD Task
Gán Task cho User
Gán Task cho Project
Lấy Task theo User
Lấy Task theo Project
Kiểm tra tồn tại User/Project trước khi tạo Task

📮 API mẫu

Task API
GET /api/tasks → Lấy tất cả task
GET /api/tasks/user/{userId} → Lấy task theo user
GET /api/tasks/project/{projectId} → Lấy task theo project
POST /api/tasks → Tạo task
PUT /api/tasks/{id} → Cập nhật task

User/Auth API
POST /api/auth/login → Đăng nhập lấy token
POST /api/auth/register → Đăng ký
GET /api/users → Danh sách user (Manager only)

📌 Quy ước API
API sử dụng JSON
Status code:
200, 201 → Thành công
400 → Dữ liệu không hợp lệ
401, 403 → Không có quyền
404 → Không tìm thấy

Security:
Authorization: Bearer <token>

⚙️ Cấu hình hệ thống

DEV
Chạy local
Hiển thị log SQL

PROD
Chạy server
Tối ưu hiệu năng

🗄 Database
Database: project_iku
Port: 1433

CREATE DATABASE project_iku;

Hibernate:
ddl-auto=update → tự động cập nhật bảng

▶️ Hướng dẫn chạy project

Cách 1: Chạy bằng IDE
Clone project
Cấu hình database
Chạy ProjectIkuApplication.java

Cách 2: Build JAR
mvn clean package -DskipTests
java -jar target/NguyenTrungHieu_TH03575-0.0.1-SNAPSHOT.jar

🧪 Test với Swagger
http://localhost:8080/swagger-ui/index.html

Login để lấy token
Authorize với Bearer token
Test API trực tiếp

👨‍💻 Thông tin sinh viên
Nguyễn Trung Hiếu
TH03575
Backend Java Intern
FPT Polytechnic
