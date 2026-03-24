🚀 Iku Project - Nguyễn Trung Hiếu
📌 Giới thiệu

Iku Project là một dự án Spring Boot REST API được xây dựng trong quá trình thực tập Backend Java.
Dự án tập trung vào hệ thống quản lý User – Project – Task, áp dụng kiến trúc RESTful API chuẩn, tách lớp rõ ràng và xử lý exception tập trung.

📋 Mô tả nghiệp vụ (Business Description)

Hệ thống hỗ trợ quản lý công việc nội bộ với 3 thực thể chính:

👤 User
Người dùng hệ thống
Có vai trò (Role)
Có thể tham gia nhiều dự án
Có thể đảm nhận nhiều công việc
📌 Project
Đại diện cho một dự án cụ thể
Trạng thái:
PLANNING
IN_PROGRESS
DONE
📝 Task
Đơn vị công việc nhỏ nhất
Gắn với một Project và một User chịu trách nhiệm
Trạng thái:
TODO
IN_PROGRESS
DONE
🔗 Quan hệ nghiệp vụ
Một User có thể được gán nhiều Task
Một Project có thể chứa nhiều Task
Mỗi Task chỉ thuộc về:
Một User
Một Project
(tại một thời điểm)
🎯 Mục tiêu
Làm quen với cấu trúc project Spring Boot chuẩn

Xây dựng REST API theo mô hình:

Controller → Service → Repository
Áp dụng:
DTO
Validation
Exception Handling
Thực hành bảo mật với:
Spring Security
JWT
Triển khai tài liệu API với:
Swagger UI
🛠 Công nghệ sử dụng
Java 17 & Spring Boot 3.x
Spring Data JPA & Hibernate
Spring Security & JWT (JSON Web Token)
Springdoc OpenAPI (Swagger UI)
Database: SQL Server
📚 Thư viện hỗ trợ
ModelMapper
Lombok
Hibernate Validator
🧰 Công cụ
Maven
Git & GitHub
📂 Cấu trúc project
src/main/java/com/example/projectiku

├── config        # Cấu hình Security, Swagger, ModelMapper
├── controller    # Xử lý request/response API
├── dto           # Request / Response DTO
├── entity        # Entity mapping database (User, Project, Task)
├── enums         # Enum trạng thái (Role, Status)
├── exception     # Custom Exception & Global Exception Handler
├── repository    # JPA Repository interface
├── security      # JWT Filter & Authentication
└── service       # Business logic (Interface & Implementation)
🚀 Chức năng đã hoàn thành
🔐 Authentication & Authorization
Đăng ký & Đăng nhập người dùng
Xác thực bằng JWT
Phân quyền USER / MANAGER bằng Spring Security
Bảo vệ API theo role
Xử lý lỗi:
401 Unauthorized
403 Forbidden
👤 User Module
CRUD User
Validate dữ liệu đầu vào
Kiểm tra trùng:
Username
Email
Mã hóa mật khẩu bằng BCrypt
📌 Project Module
CRUD Project
Quản lý trạng thái dự án
Thiết lập quan hệ 1-N với Task
📝 Task Module
CRUD Task
Gán Task cho:
User
Project
Lọc Task theo:
User
Project
Xử lý logic:
Kiểm tra tồn tại của User/Project trước khi tạo Task
📮 API mẫu
📝 Task API
Method	Endpoint	Mô tả
GET	/api/tasks	Lấy tất cả task
GET	/api/tasks/user/{userId}	Lấy task theo user
GET	/api/tasks/project/{projectId}	Lấy task theo dự án
POST	/api/tasks	Tạo task mới
PUT	/api/tasks/{id}	Cập nhật task
👤 User/Auth API
Method	Endpoint	Mô tả
POST	/api/auth/login	Đăng nhập lấy Token
POST	/api/auth/register	Đăng ký tài khoản
GET	/api/users	Danh sách user (Manager only)
📌 Quy ước API
Format: JSON
Status Code:
200 / 201: Thành công
400: Dữ liệu không hợp lệ
401 / 403: Chưa xác thực / Không có quyền
404: Không tìm thấy tài nguyên

Security:

Authorization: Bearer <token>
⚙️ Cấu hình Hệ thống (Profile & Database)
🔹 Môi trường
DEV
Chạy local
Hiển thị log SQL chi tiết
File: application-dev.properties
PROD
Chạy server
Tối ưu hiệu năng & bảo mật
File: application-prod.properties
🗄 Database (SQL Server)
Database Name: project_iku
Port: 1433

Hibernate:

ddl-auto=update

(Tự động cập nhật bảng, không mất dữ liệu)

▶️ Hướng dẫn Setup & Chạy Project
🔹 Cách 1: Chạy qua IDE (IntelliJ / Eclipse)
git clone <your-repo-url>
Mở SQL Server và tạo database:
CREATE DATABASE IKU;
Cấu hình username/password trong application.properties
Chạy file:
ProjectIkuApplication.java
🔹 Cách 2: Build file JAR
mvn clean package -DskipTests
java -jar target/NguyenTrungHieu_TH03575-0.0.1-SNAPSHOT.jar
🧪 Kiểm thử với Swagger UI

Truy cập:

http://localhost:8080/swagger-ui/index.html
Các bước:
Lấy Token:
Gọi API: POST /api/auth/login
Sử dụng tài khoản Manager

Authorize:

Nhấn nút Authorize
Nhập:
Bearer <token>
Test:
Gọi API trực tiếp trên trình duyệt
👨‍💻 Thông tin sinh viên
Họ tên: Nguyễn Trung Hiếu
Mã sinh viên: TH03575
Vị trí: Thực tập sinh Backend Java
Trường: FPT Polytechnic
