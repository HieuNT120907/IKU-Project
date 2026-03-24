📦 Iku Project – Order Management System
📌 Giới thiệu

Iku Project là một dự án Spring Boot REST API được xây dựng trong quá trình thực tập Backend Java tại FPT Polytechnic.
Dự án tập trung vào quản lý hệ thống Người dùng – Sản phẩm – Đơn hàng, áp dụng kiến trúc tách lớp rõ ràng, bảo mật bằng JWT và xử lý ngoại lệ tập trung.

📋 Mô tả nghiệp vụ (Business Description)

Hệ thống hỗ trợ quản lý quy trình bán hàng và điều phối công việc nội bộ:

👤 User
Người sử dụng hệ thống (Nhân sự).
Có vai trò xác định quyền hạn:
ROLE_ADMIN
ROLE_USER
Một User có thể phụ trách nhiều Đơn hàng.
🛍️ SanPham (Sản phẩm/Dự án)
Đại diện cho danh mục hàng hóa hoặc dự án.
Mỗi sản phẩm có:
Mã định danh
Đơn giá (BigDecimal)
Nhà sản xuất
📝 DonHang (Task / Công việc)
Đơn vị công việc trung tâm:
Thuộc về một SanPham
Được gán cho một User

Có trạng thái xử lý:

TODO → IN_PROGRESS → DONE
🔗 Quan hệ nghiệp vụ
Một User phụ trách nhiều DonHang (1-N).
Một SanPham chứa nhiều DonHang (1-N).
Hệ thống chặn xóa hoặc sửa thông tin quan trọng khi đơn hàng đã ở trạng thái DONE.
🎯 Mục tiêu

Làm quen với cấu trúc project Spring Boot chuẩn:

Controller – Service – Repository
Triển khai bảo mật API bằng Spring Security & JWT
Áp dụng DTO (Data Transfer Object) và ModelMapper
Thực hành Unit Test với JUnit 5 & Mockito
Tự động hóa tài liệu API bằng Swagger UI
🛠 Công nghệ sử dụng
Java 17
Spring Boot 3.2.4
Spring Data JPA & Hibernate
Spring Security & JWT
Springdoc OpenAPI (Swagger UI)
JUnit 5 & Mockito
SQL Server
Công cụ:
Maven
Postman
Lombok
ModelMapper
📂 Cấu trúc Project
src/main/java/com/example/nguyentrunghieu_th03575
├── config          # Cấu hình Security, Swagger, ModelMapper
├── controller      # Xử lý Request/Response API
├── dto             # Request / Response DTO
├── entity          # Mapping Database (JPA Entities)
├── enums           # Enum trạng thái (TaskStatus)
├── exception       # Custom Exception & Global Handler
├── repository      # Tầng truy xuất dữ liệu (JPA Repository)
├── security        # Xử lý Filter JWT và phân quyền
└── service         # Interface & Business Logic (impl)
🚀 Chức năng đã hoàn thành
👤 User & Auth Module
Xác thực người dùng bằng JWT
Phân quyền:
ROLE_ADMIN: Toàn quyền
ROLE_USER: Xem và lọc
API đăng nhập và lấy thông tin User hiện tại
📝 DonHang (Order) Module
CRUD Đơn hàng đầy đủ
Gán nhân sự cho công việc (assignTask)
Cập nhật trạng thái công việc (theo vòng đời)
Lấy danh sách task:
Theo nhân sự
Theo dự án
Lọc đơn hàng theo trạng thái (TaskStatus)
⚠️ Xử lý Exception & Validation
Kiểm tra trùng:
Mã đơn hàng
Username
Custom Exception:
CustomResourceNotFound
Validate dữ liệu đầu vào bằng @Valid
📮 API mẫu (Main Endpoints)
Method	Endpoint	Mô tả
POST	/api/auth/login	Đăng nhập nhận JWT Token
GET	/api/donhangs	Lấy toàn bộ danh sách đơn hàng
PATCH	/api/donhangs/{id}/status	Cập nhật trạng thái
PATCH	/api/donhangs/{taskId}/assign/{userId}	Gán nhân sự
GET	/api/donhangs/user/{userId}	Lấy task theo nhân viên
DELETE	/api/donhangs/{id}	Xóa đơn hàng (ADMIN)
📌 Quy ước API
Chuẩn RESTful
Dữ liệu trao đổi: JSON
HTTP Status Codes
200 OK – Thành công
201 Created – Tạo mới thành công
400 Bad Request – Dữ liệu không hợp lệ
404 Not Found – Không tìm thấy
403 Forbidden – Không đủ quyền
⚙️ Cấu hình Hệ thống
🗄 Database (SQL Server)
Database Name: IKU
Tài khoản: sa / 123456
Initial Data:
Tự động tạo bảng và chèn ~30 đơn hàng từ data.sql
🧠 Hibernate Configuration
ddl-auto=create: Tự động tạo bảng
show-sql=true: Hiển thị SQL để debug
▶️ Hướng dẫn Setup & Chạy Project
1. Setup môi trường
Cài đặt:
Java 17
SQL Server

Tạo database:

IKU
Cấu hình trong application.properties
2. Khởi chạy
Mở project bằng IntelliJ IDEA
Maven tự động tải dependencies
Chạy class:
NguyenTrungHieuTh03575Application.java
3. Test API bằng Swagger
Truy cập:
http://localhost:8080/swagger-ui/index.html
Đăng nhập:
POST /api/auth/login

Tài khoản mẫu:

username: hieunt
password: 12345
Sau đó:
Nhấn Authorize

Nhập:

Bearer <token>
📅 Kế hoạch phát triển
 Xây dựng cấu trúc project chuẩn
 CRUD Đơn hàng & Sản phẩm
 Tích hợp Spring Security & JWT
 Global Exception Handling
 Unit Test (Service Layer)
 Xây dựng Frontend (React / Angular)
 Deploy Docker / Cloud
👨‍💻 Thông tin sinh viên
Họ tên: Nguyễn Trung Hiếu
MSV: TH03575
Vị trí: Thực tập sinh Backend Java
GitHub: [Link GitHub của Hiếu tại đây]
