Iku Project - Nguyễn Trung Hiếu

📌 Giới thiệu
Iku Project là một dự án Spring Boot REST API được xây dựng trong quá trình thực tập Backend Java.
Dự án tập trung vào việc quản lý User – Project – Task, áp dụng kiến trúc RESTful API, tách lớp rõ ràng và xử lý exception tập trung.

📋 Mô tả nghiệp vụ (Business Description)
Hệ thống Iku Project là hệ thống quản lý công việc nội bộ, được xây dựng nhằm hỗ trợ việc quản lý người dùng (User), dự án (Project) và công việc (Task).

👤 User
User là người sử dụng hệ thống, có thể tham gia nhiều Project và được gán nhiều Task khác nhau.

📌 Project
Project đại diện cho một dự án cụ thể.
Mỗi Project bao gồm nhiều Task và có trạng thái riêng:
PLANNING, IN_PROGRESS, DONE

📝 Task
Task là đơn vị công việc nhỏ nhất trong hệ thống.

Mỗi Task:

Thuộc về một Project
Được gán cho một User
Có trạng thái xử lý: TODO, IN_PROGRESS, DONE

🔗 Quan hệ nghiệp vụ

Một User có thể được gán nhiều Task
Một Project có thể chứa nhiều Task
Mỗi Task chỉ thuộc về một User và một Project tại một thời điểm

Hệ thống hỗ trợ các chức năng:

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
entity # Entity mapping database (User, Project, Task)
enums # Enum trạng thái (Role, Status)
exception # Custom Exception & Global Exception Handler
repository # JPA Repository interface
security # JWT Filter và Authentication
service # Business logic (Interface & Implementation)

🚀 Chức năng đã hoàn thành

🔐 Authentication & Authorization

Đăng ký & Đăng nhập người dùng
Xác thực bằng JWT
Phân quyền USER / MANAGER bằng Spring Security
Bảo vệ API theo role
Xử lý lỗi 401 và 403

👤 User Module

CRUD User
Validate dữ liệu đầu vào
Kiểm tra trùng username, email
Mã hóa mật khẩu bằng BCrypt

📌 Project Module

CRUD Project
Quản lý trạng thái dự án
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
GET /api/tasks/project/{projectId} → Lấy task theo dự án
POST /api/tasks → Tạo task mới
PUT /api/tasks/{id} → Cập nhật task

User/Auth API

POST /api/auth/login → Đăng nhập lấy Token
POST /api/auth/register → Đăng ký tài khoản
GET /api/users → Danh sách user (Manager only)

📌 Quy ước API

Format: JSON
Status Code:
200 / 201 → Thành công
400 → Dữ liệu không hợp lệ
401 / 403 → Chưa xác thực / Không có quyền
404 → Không tìm thấy tài nguyên

Security:
Authorization: Bearer <token>

⚙️ Cấu hình Hệ thống (Profile & Database)

DEV

Chạy local
Hiển thị log SQL chi tiết

PROD

Chạy server
Tối ưu hiệu năng và bảo mật

🗄 Database (SQL Server)
Database Name: IKU
Port: 1433

CREATE DATABASE IKU;

Hibernate:
ddl-auto=update → Tự động cập nhật bảng, không mất dữ liệu

▶️ Hướng dẫn Setup & Chạy Project

Cách 1: Chạy qua IDE

Clone project: git clone <your-repo-url>
Cấu hình database trong application.properties
Chạy ProjectIkuApplication.java

Cách 2: Build file JAR

mvn clean package -DskipTests
java -jar target/NguyenTrungHieu_TH03575-0.0.1-SNAPSHOT.jar

🧪 Kiểm thử với Swagger UI

Truy cập:
http://localhost:8080/swagger-ui/index.html

Các bước:

Gọi API POST /api/auth/login để lấy token
Nhấn Authorize và nhập Bearer <token>
Test API trực tiếp trên trình duyệt

👨‍💻 Thông tin sinh viên

Họ tên: Nguyễn Trung Hiếu
Mã sinh viên: TH03575
Vị trí: Thực tập sinh Backend Java
Trường: FPT Polytechnic
