# 📦 Iku Project – Order Management System

## 📌 Giới thiệu
**Iku Project** là một dự án **Spring Boot REST API** được xây dựng trong quá trình thực tập Backend Java tại FPT Polytechnic. Dự án tập trung vào quản lý hệ thống **Người dùng – Sản phẩm – Đơn hàng**, áp dụng kiến trúc tách lớp rõ ràng, bảo mật JWT và xử lý ngoại lệ tập trung.

---

## 📋 Mô tả nghiệp vụ (Business Description)
Hệ thống hỗ trợ quản lý quy trình bán hàng và điều phối công việc nội bộ:

### 👤 User (Nhân sự)
Người sử dụng hệ thống, có vai trò xác định quyền hạn (`ROLE_ADMIN` hoặc `ROLE_USER`). Một User có thể phụ trách nhiều Đơn hàng.

### 🛍️ SanPham (Sản phẩm/Dự án)
Đại diện cho danh mục hàng hóa hoặc dự án. Mỗi sản phẩm có mã định danh, đơn giá (`BigDecimal`) và nhà sản xuất.

### 📝 DonHang (Task/Công việc)
Đơn vị công việc trung tâm:
* Thuộc về một **SanPham** (Dự án).
* Được gán cho một **User** (Nhân sự).
* Có trạng thái xử lý: **TODO → IN_PROGRESS → DONE**.

### 🔗 Quan hệ nghiệp vụ
* Một User phụ trách nhiều DonHang (1-N).
* Một SanPham chứa nhiều DonHang (1-N).
* Hệ thống chặn xóa hoặc sửa thông tin khi Đơn hàng đã ở trạng thái **DONE**.

---

## 🎯 Mục tiêu
* Làm quen với cấu trúc project Spring Boot chuẩn (Controller – Service – Repository).
* Triển khai bảo mật tài nguyên API bằng **Spring Security & JWT**.
* Áp dụng **DTO** và **ModelMapper** để tối ưu dữ liệu trả về.
* Thực hành Unit Test chuyên sâu với **JUnit 5 & Mockito**.
* Tự động hóa tài liệu API với **Swagger UI**.

---

## 🛠 Công nghệ sử dụng
* **Core:** Java 17 & Spring Boot 3.2.4
* **ORM:** Spring Data JPA & Hibernate
* **Security:** Spring Security & JWT (JSON Web Token)
* **API Docs:** Springdoc OpenAPI (Swagger UI)
* **Testing:** JUnit 5 & Mockito
* **Database:** SQL Server
* **Tools:** Maven, Postman, Lombok, ModelMapper

---

## 📂 Cấu trúc Project
```text
src/main/java/com/example/nguyentrunghieu_th03575
├── config          # Cấu hình Security, Swagger, ModelMapper
├── controller      # Xử lý Request/Response API
├── dto             # Request / Response DTO (Data Transfer Object)
├── entity          # Mapping Database (JPA Entities)
├── enums           # Enum trạng thái (TaskStatus)
├── exception       # Custom Exception & Global Handler
├── repository      # Tầng truy xuất dữ liệu (JPA Repository)
├── security        # Xử lý Filter JWT và phân quyền
└── service         # Interface & Business Logic (impl)
```
---

---

## 🚀 Chức năng đã hoàn thành

### 👤 User & Auth Module
* **Xác thực:** Người dùng bằng JWT (JSON Web Token).
* **Phân quyền:** * `ROLE_ADMIN`: Toàn quyền quản trị hệ thống.
    * `ROLE_USER`: Quyền nhân viên (Xem và lọc dữ liệu).
* **API:** Đăng nhập và lấy thông tin User hiện tại từ hệ thống.

### 📝 DonHang (Order) Module
* **CRUD:** Thực hiện đầy đủ các thao tác Thêm, Sửa, Xóa, Xem đơn hàng.
* **Gán việc:** Chức năng `assignTask` để phân bổ nhân sự cho công việc.
* **Trạng thái:** Cập nhật trạng thái công việc tuân thủ nghiêm ngặt logic vòng đời.
* **Truy vấn:** Lấy danh sách task theo nhân sự hoặc theo từng dự án cụ thể.
* **Bộ lọc:** Lọc đơn hàng nhanh chóng theo `TaskStatus`.

### ⚠️ Xử lý Exception & Validation
* **Kiểm tra dữ liệu:** Check trùng mã đơn hàng và username ngay khi tạo.
* **Ngoại lệ:** Sử dụng `CustomResourceNotFound` khi ID không tồn tại trong hệ thống.
* **Validation:** Kiểm soát dữ liệu đầu vào bằng `@Valid` (Bắt lỗi trường trống, sai định dạng...).

---

## 📮 API mẫu (Main Endpoints)

| Method | Endpoint | Mô tả |
| :--- | :--- | :--- |
| `POST` | `/api/auth/login` | Đăng nhập nhận JWT Token |
| `GET` | `/api/donhangs` | Lấy toàn bộ danh sách đơn hàng |
| `PATCH` | `/api/donhangs/{id}/status` | Cập nhật trạng thái công việc |
| `PATCH` | `/api/donhangs/{taskId}/assign/{userId}` | Gán nhân sự phụ trách |
| `GET` | `/api/donhangs/user/{userId}` | Lấy task của một nhân sự |
| `DELETE` | `/api/donhangs/{id}` | Xóa đơn hàng (Chỉ ROLE_ADMIN) |

---

## 📌 Quy ước API
* **Chuẩn RESTful:** Dữ liệu trao đổi hoàn toàn qua định dạng JSON.
* **HTTP Status Codes:**
    * `200 OK` – Thành công.
    * `201 Created` – Tạo mới thành công.
    * `400 Bad Request` – Dữ liệu đầu vào không hợp lệ.
    * `404 Not Found` – Không tìm thấy tài nguyên/ID.
    * `403 Forbidden` – Không đủ quyền truy cập.

---

## ⚙️ Cấu hình Hệ thống (Database)

### 🗄 Database (SQL Server)
* **Database Name:** `IKU`
* **Tài khoản:** `sa` / `123456`
* **Initial Data:** Hệ thống tự động chạy `data.sql` để chèn 30 đơn hàng mẫu khi khởi tạo.

### 🧠 Hibernate Configuration
* `spring.jpa.hibernate.ddl-auto=create`: Tự động tạo bảng từ Entity Java.
* `spring.jpa.show-sql=true`: Hiển thị log SQL trên Console để hỗ trợ debug.

---

## ▶️ Hướng dẫn Setup & Chạy Project

### 1. Setup môi trường
* Cài đặt Java 17 và SQL Server trên máy tính.
* Tạo mới một Database có tên là `IKU`.
* Cấu hình lại thông tin kết nối trong file `application.properties`.

### 2. Khởi chạy
* Mở project bằng IntelliJ IDEA.
* Chờ Maven tự động tải các thư viện cần thiết.
* Chạy Class chính: `NguyenTrungHieuTh03575Application.java`.

### 3. Test API qua Swagger
* Truy cập địa chỉ: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html).
* Gọi API `/api/auth/login` với tài khoản `hieunt` / `12345` để lấy token.
* Nhấn nút **Authorize**, nhập theo cú pháp `Bearer <token>` để bắt đầu test các API bảo mật.

---

## 📅 Kế hoạch phát triển

- [x] Xây dựng cấu trúc project chuẩn. ✅
- [x] Triển khai CRUD Đơn hàng & Sản phẩm. ✅
- [x] Tích hợp Spring Security & JWT. ✅
- [x] Xử lý lỗi tập trung (Global Exception Handling). ✅
- [x] Viết Unit Test cho tầng Service. ✅
- [ ] Xây dựng giao diện Web (Frontend) bằng React/Angular. ⏳
- [ ] Triển khai lên Docker/Cloud. ⏳

---

## 👨‍💻 Thông tin sinh viên
* **Họ tên:** Nguyễn Trung Hiếu
* **MSV:** TH03575
* **Vị trí:** Thực tập sinh Backend Java
* **GitHub:** [Chèn link GitHub của bạn tại đây]

---
**© 2026 Nguyễn Trung Hiếu - Iku Project**
