Iku Project

📌 Giới thiệu
Iku Project là một dự án Spring Boot REST API được xây dựng trong quá trình thực tập Backend Java.
Dự án tập trung vào việc quản lý User – Project – Task, áp dụng kiến trúc RESTful API chuẩn, tách lớp rõ ràng và xử lý exception tập trung.

📋 Mô tả nghiệp vụ (Business Description)
Hệ thống Iku Project là hệ thống quản lý công việc nội bộ, được xây dựng nhằm hỗ trợ việc quản lý người dùng (User), dự án (Project) và công việc (Task).

👤 User
User là người sử dụng hệ thống, có thể tham gia nhiều Project và được gán nhiều Task khác nhau.

📌 Project
Project đại diện cho một dự án cụ thể. Mỗi Project bao gồm nhiều Task và có trạng thái riêng (PLANNING, IN_PROGRESS, DONE).

📝 Task
Task là đơn vị công việc nhỏ nhất trong hệ thống.

Mỗi Task:

Thuộc về một Project
Được gán cho một User
Có trạng thái xử lý (TODO, IN_PROGRESS, DONE)

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
Đóng gói ứng dụng và phân tách môi trường (Dev/Prod)

📄 README Structure
Giới thiệu dự án
Mục tiêu thực tập
Công nghệ sử dụng
Cấu trúc project
Chức năng đã hoàn thành
API mẫu
Quy ước API
Cấu hình Database
Hướng dẫn chạy project

🛠 Công nghệ sử dụng
Java 17
Spring Boot 3.x
Spring Data JPA & Hibernate
Spring Security & JWT (JSON Web Token)
Springdoc OpenAPI (Swagger UI)
Database: SQL Server
Công cụ: Maven, Git & GitHub

📂 Cấu trúc project
src/main/java/com/example/projectiku
│
├── config # Cấu hình Security, Swagger, ModelMapper
├── controller # Xử lý request/response API
├── dto # Request / Response DTO
├── entity # Entity mapping database
├── enums # Enum trạng thái
├── exception # Custom Exception & Global Handler
├── repository # JPA Repository
├── security # Filter và xử lý JWT
└── service # Interface service & Business logic (impl)

🚀 Chức năng đã hoàn thành

👤 User Module
CRUD User
Validate dữ liệu
Kiểm tra trùng username, email
DTO + ModelMapper
Custom Exception + Global Handler

📌 Project Module
CRUD Project
Quản lý trạng thái (PLANNING, IN_PROGRESS, DONE)
Quan hệ 1-N với Task

📝 Task Module
CRUD Task
Gán Task cho User
Gán Task cho Project
Lấy Task theo User
Lấy Task theo Project
Quản lý trạng thái (TODO, IN_PROGRESS, DONE)
Validate dữ liệu đầu vào
Kiểm tra tồn tại User & Project trước khi tạo Task
Mapping quan hệ @ManyToOne
Xử lý Exception khi không tìm thấy User / Project

🔐 Authentication & Authorization
Xác thực người dùng bằng JWT
Phân quyền USER / MANAGER bằng Spring Security
Bảo vệ API theo role
Xử lý 401 (Unauthorized) và 403 (Forbidden)

📮 API mẫu

Task API

Method Endpoint Mô tả
GET /api/tasks Lấy tất cả task
GET /api/tasks/user/{userId} Lấy task theo user
GET /api/tasks/project/{projectId} Lấy task theo project
POST /api/tasks Tạo task
PUT /api/tasks/{id} Cập nhật task

User API

Method Endpoint Mô tả
POST /api/auth/login Đăng nhập lấy Token
POST /api/auth/register Đăng ký tài khoản
GET /api/users Danh sách user (Manager only)

📌 Quy ước API
API tuân theo chuẩn RESTful
Request / Response sử dụng JSON

HTTP Status Code:
200 – Thành công
201 – Tạo mới thành công
400 – Dữ liệu không hợp lệ
401 – Chưa xác thực
403 – Không có quyền
404 – Không tìm thấy tài nguyên

API được bảo vệ bằng JWT
Truyền token qua Header: Authorization: Bearer

⚠️ Xử lý Exception
Custom Exception → 404 NOT FOUND
Validation Error → 400 BAD REQUEST
Global Exception Handling bằng @ControllerAdvice

⚙️ Cấu hình Hệ thống (Profile & Database)
Dự án hỗ trợ 2 môi trường thông qua Profile:

DEV (application-dev.properties): Chạy ở Local, hiển thị log SQL chi tiết.
PROD (application-prod.properties): Chạy ở Server, tối ưu hiệu năng và bảo mật.

🗄 Database (SQL Server)
Database Name: project_iku
Port: 1433

CREATE DATABASE project_iku;

🧠 Hibernate Configuration
ddl-auto=update → Tự động tạo & cập nhật bảng theo Entity

▶️ Hướng dẫn Setup & Chạy Project

Cách 1: Chạy trực tiếp qua IDE
Clone project: git clone <your-repo-url>
Cấu hình username/password SQL Server
Chạy ProjectIkuApplication.java

Cách 2: Build và chạy file JAR
mvn clean package -DskipTests
java -jar target/NguyenTrungHieu_TH03575-0.0.1-SNAPSHOT.jar

🧪 Hướng dẫn Test API qua Swagger

Truy cập Swagger: http://localhost:8080/swagger-ui/index.html

Lấy Token (Login):
Gọi API POST /api/auth/login
Copy token trả về

Authorize:
Nhập Bearer <token>

Test API trực tiếp trên trình duyệt

📅 Kế hoạch phát triển
Xây dựng cấu trúc project Spring Boot
Hoàn thành User Module
Hoàn thành Task Module
Hoàn thành Project Module
Thêm Authentication & Authorization
Tích hợp Swagger

👨‍💻 Thông tin sinh viên

Họ tên: Nguyễn Trung Hiếu
Mã sinh viên: TH03575
Vị trí: Thực tập sinh Backend Java
Trường: FPT Polytechnic
