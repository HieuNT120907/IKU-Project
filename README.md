# 📦 DỰ ÁN QUẢN LÝ ĐƠN HÀNG – IKU PROJECT

**Sinh viên thực hiện:** Nguyễn Trung Hiếu
**Mã sinh viên:** TH03575
**Vị trí:** Thực tập sinh Backend Java – FPT Polytechnic

---

## 📌 1. Giới thiệu dự án

**Iku Project** là hệ thống REST API xây dựng bằng Spring Boot, nhằm tối ưu hóa quy trình quản lý bán hàng nội bộ.
Dự án tập trung vào 3 thành phần chính:

* Người dùng (**User**)
* Sản phẩm (**Product**)
* Đơn hàng (**Order**)

Hệ thống được thiết kế theo kiến trúc phân lớp rõ ràng, đảm bảo dễ bảo trì và mở rộng, đồng thời áp dụng các tiêu chuẩn bảo mật hiện đại.

---

## 📋 2. Mô tả nghiệp vụ

Hệ thống quản lý mối quan hệ giữa các thực thể:

### 👤 User

* Đại diện cho người sử dụng hệ thống
* Bao gồm khách hàng và quản lý

### 🛍️ Product

* Danh sách sản phẩm trong kho
* Bao gồm: mã, tên, giá và thông tin liên quan

### 📝 Order

* Thành phần trung tâm của hệ thống
* Mỗi đơn hàng:

  * Thuộc về một **User**
  * Gắn với một **Product**
  * Có trạng thái xử lý theo luồng:

  ```
  TODO → IN_PROGRESS → DONE
  ```

---

## 🛠 3. Công nghệ sử dụng

* **Backend:** Java 17, Spring Boot 3.2.4
* **Data Access:** Spring Data JPA, Hibernate, SQL Server
* **Security:** Spring Security, JWT (JSON Web Token)
* **API Docs:** SpringDoc OpenAPI (Swagger UI)
* **Testing:** JUnit 5, Mockito
* **Tools:** Maven, Lombok, ModelMapper

---

## 📂 4. Cấu trúc Project

```
src/main/java/com/example/nguyentrunghieu_th03575
├── config        # Cấu hình Security, Swagger, ModelMapper
├── controller    # Xử lý Request & Response API
├── dto           # Đối tượng trung gian (Request/Response)
├── entity        # Mapping Database (JPA Entities)
├── enums         # Trạng thái đơn hàng
├── exception     # Xử lý lỗi tập trung
├── repository    # Data Access Layer
├── security      # JWT Filter & phân quyền
└── service       # Business Logic
```

---

## 🚀 5. Chức năng đã hoàn thành

### 🔐 Bảo mật & Phân quyền

* Xác thực người dùng bằng JWT
* Phân quyền:

  * **USER:** Chỉ xem dữ liệu
  * **MANAGER:** Toàn quyền CRUD
* Lấy thông tin user hiện tại từ hệ thống

---

### 📦 Quản lý Đơn hàng

* CRUD đầy đủ cho **Đơn hàng** và **Sản phẩm**
* Áp dụng logic nghiệp vụ:

  * Không cho phép chỉnh sửa đơn hàng khi đã ở trạng thái **DONE**
  * Đảm bảo tính minh bạch và toàn vẹn dữ liệu

---

### 🧪 Kiểm thử

* Viết Unit Test cho `DonHangService` bằng Mockito
* Đảm bảo logic nghiệp vụ hoạt động chính xác trước khi triển khai

---

## 📮 6. Danh sách API chính

| Method | Endpoint           | Mô tả                    |
| ------ | ------------------ | ------------------------ |
| POST   | /api/auth/login    | Đăng nhập và lấy JWT     |
| GET    | /api/donhangs      | Lấy danh sách đơn hàng   |
| GET    | /api/donhangs/{id} | Lấy chi tiết đơn hàng    |
| POST   | /api/donhangs      | Tạo mới đơn hàng         |
| PUT    | /api/donhangs/{id} | Cập nhật (chặn nếu DONE) |
| DELETE | /api/donhangs/{id} | Xóa (chỉ MANAGER)        |

---

## ⚙️ 7. Hướng dẫn chạy Project

### 🗄️ Cấu hình Database

```sql
CREATE DATABASE NguyenTrungHieu_TH03575;
```

* Cập nhật `username` và `password` trong `application.properties`

---

### ▶️ Chạy ứng dụng

1. Mở project bằng IntelliJ IDEA
2. Chạy class chính:

```
NguyenTrungHieuTh03575Application
```

3. Truy cập Swagger:

```
http://localhost:8080/swagger-ui/index.html
```

---

## 🧪 8. Test API bằng Swagger

1. Mở Swagger UI
2. Gọi API **/api/auth/login** để lấy Token
3. Nhấn **Authorize** (biểu tượng ổ khóa)
4. Dán Token vào
5. Thử nghiệm các API với **Try it out**

---

## © 2026

**Nguyễn Trung Hiếu – TH03575**
