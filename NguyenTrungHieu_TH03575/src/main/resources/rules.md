BỘ QUY TẮC NGHIỆP VỤ HỆ THỐNG (BUSINESS RULES)
Dự án: Quản lý Nhân sự - Task - Dự án
Sinh viên thực hiện: Nguyễn Trung Hiếu - TH03575

1. Quy tắc về Thực thể (Entities)
   User (Nhân sự):

Mỗi nhân sự phải có một username duy nhất (Unique).

Mật khẩu phải có độ bảo mật tối thiểu (ít nhất 6 ký tự).

Mỗi User được phân một vai trò (UserRole): ROLE_ADMIN (Quản lý) hoặc ROLE_USER (Nhân viên).

SanPham (Dự án/Sản phẩm):

Đóng vai trò là danh mục hoặc dự án chứa các Task.

Mỗi sản phẩm phải có tên và đơn giá xác định.

DonHang (Task/Công việc):

Mỗi Task phải có mã định danh duy nhất (ví dụ: DH001).

Số lượng công việc phải là số dương (> 0).

2. Quy tắc Quan hệ (Relationship Rules)
   Quy tắc Gán việc (Assignment):

1-N (User - Task): Một nhân viên có thể đảm nhận nhiều Task cùng lúc, nhưng một Task tại một thời điểm chỉ được gán cho 1 nhân viên chịu trách nhiệm.

1-N (Project - Task): Một dự án (Sản phẩm) có thể chia thành nhiều Task nhỏ. Task bắt buộc phải thuộc về một dự án cụ thể.

3. Quy tắc Luồng trạng thái (Task Status Flow)
   Trạng thái công việc phải tuân thủ nghiêm ngặt vòng đời sau thông qua Enum TrangThaiDonHang:

PENDING (Chờ xử lý): Trạng thái mặc định khi Task vừa được tạo và gán cho User.

IN_PROGRESS (Đang thực hiện): Chuyển sang khi nhân viên bắt đầu thao tác.

DONE (Hoàn thành): Trạng thái cuối cùng sau khi công việc kết thúc.

Rule chuyển đổi: Chỉ cho phép chuyển tiếp (Tiến), không cho phép chuyển ngược trạng thái từ DONE về PENDING để đảm bảo tính trung thực của báo cáo.

4. Quy tắc Kiểm soát Dữ liệu (Validation & Exception)
   Duplicate Check: Hệ thống phải kiểm tra và ném ra lỗi CustomDuplicateResource nếu người dùng cố tình tạo trùng username hoặc maDonHang.

Not Found Check: Khi truy vấn theo ID, nếu không tồn tại bản ghi, hệ thống phải trả về lỗi CustomResourceNotFound.

BigDecimal Accuracy: Toàn bộ giá trị tiền tệ của Sản phẩm phải được xử lý bằng kiểu BigDecimal để tránh sai số làm tròn trong các phép tính toán tài chính.

5. Quy tắc Lọc dữ liệu (Filtering Rules)
   Hệ thống cung cấp các bộ lọc bắt buộc để phục vụ quản lý:

Lọc danh sách Task theo từng Nhân sự (để đánh giá hiệu suất).

Lọc danh sách Task theo từng Dự án (để theo dõi tiến độ dự án).

Lọc danh sách Task theo Trạng thái (để biết việc gì còn tồn đọng).