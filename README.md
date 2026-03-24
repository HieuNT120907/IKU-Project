📦 Iku Project – Order Management System
📌 Giới thiệu

Iku Project là một dự án Spring Boot REST API được xây dựng trong quá trình thực tập Backend Java.
Dự án tập trung vào việc quản lý User – Product – Order, áp dụng kiến trúc RESTful API, tách lớp rõ ràng và xử lý exception tập trung.

📋 Mô tả nghiệp vụ (Business Description)

Hệ thống hỗ trợ quản lý quy trình bán hàng và điều phối công việc nội bộ.

👤 User

User là người sử dụng hệ thống, có thể:

Tham gia nhiều công việc
Được gán nhiều đơn hàng
🛍️ SanPham (Product / Dự án)
Đại diện cho sản phẩm hoặc dự án
Bao gồm:
Mã định danh
Đơn giá (BigDecimal)
Nhà sản xuất
📝 DonHang (Task / Công việc)

Đơn vị công việc trung tâm của hệ thống.

Mỗi DonHang:

Thuộc về một SanPham
Được gán cho một User
Có trạng thái:
TODO → IN_PROGRESS → DONE
🔗 Quan hệ nghiệp vụ
Một User có thể được gán nhiều DonHang
Một SanPham có nhiều DonHang
Mỗi DonHang chỉ thuộc:
1 User
1 SanPham
🎯 Mục tiêu
Làm quen với cấu trúc project Spring Boot chuẩn

Xây dựng REST API theo mô hình:

Controller – Service – Repository
Áp dụng:
DTO
Validation
Exception Handling
Thực hành Unit Test với JUnit & Mockito
Tích hợp tài liệu API bằng Swagger UI
📚 README Structure
Giới thiệu dự án
Mô tả nghiệp vụ
Mục tiêu
Công nghệ sử dụng
Cấu trúc project
Chức năng
API
Cấu hình
Hướng dẫn chạy
🛠 Công nghệ sử dụng
☕ Java 17
🌱 Spring Boot 3.x
🗄 Spring Data JPA & Hibernate
🔐 Spring Security & JWT
📄 Swagger UI (Springdoc OpenAPI)
🧪 JUnit 5 & Mockito
💾 SQL Server

Công cụ:

Maven
Postman
Lombok
ModelMapper
Git & GitHub
📁 Cấu trúc project
src/main/java/com/example/projectiku
│
├── config        # Cấu hình Security, Swagger, ModelMapper
├── controller    # Xử lý request/response API
├── dto           # Request / Response DTO
├── entity        # Mapping database
├── enums         # Enum trạng thái
├── exception     # Custom Exception & Global Handler
├── repository    # JPA Repository
├── security      # JWT Filter & phân quyền
└── service       # Business Logic
🚀 Chức năng đã hoàn thành
👤 User Module
CRUD User
Validate dữ liệu
Kiểm tra trùng username
DTO + ModelMapper
Global Exception Handling
🛍️ SanPham Module
CRUD Sản phẩm
Quản lý thông tin sản phẩm
Quan hệ 1-N với DonHang
📝 DonHang Module
CRUD Đơn hàng
Gán User cho công việc
Gán DonHang cho SanPham
Lấy danh sách:
Theo User
Theo SanPham

Quản lý trạng thái:

TODO → IN_PROGRESS → DONE
Validate dữ liệu đầu vào
Xử lý exception khi không tìm thấy dữ liệu
📮 API mẫu
Method	Endpoint	Mô tả
POST	/api/auth/login	Đăng nhập
GET	/api/donhangs	Lấy danh sách
PATCH	/api/donhangs/{id}/status	Update trạng thái
PATCH	/api/donhangs/{taskId}/assign/{userId}	Gán User
GET	/api/donhangs/user/{userId}	Lấy theo User
DELETE	/api/donhangs/{id}	Xóa (ADMIN)
⚙️ Cấu hình hệ thống
🗄 Database
Name: IKU
User: sa
Password: 123456
🧠 Hibernate
ddl-auto=create
show-sql=true
▶️ Hướng dẫn chạy project
1. Setup
Cài Java 17
Cài SQL Server
Tạo database:
IKU
2. Run project
Mở bằng IntelliJ
Chạy:
NguyenTrungHieuTh03575Application.java
3. Test API

Truy cập:

http://localhost:8080/swagger-ui/index.html

Login:

username: hieunt
password: 12345

Authorize:

Bearer <token>
📅 Kế hoạch phát triển
 Cấu trúc project chuẩn
 CRUD hệ thống
 JWT Authentication
 Global Exception
 Unit Test
 Frontend (React / Angular)
 Deploy Docker / Cloud
👨‍💻 Thông tin
Họ tên: Nguyễn Trung Hiếu
MSV: TH03575
Vị trí: Backend Intern
GitHub: (thêm link của bạn vào đây)
