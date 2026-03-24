package com.example.nguyentrunghieu_th03575.dto;

import com.example.nguyentrunghieu_th03575.validation.ValidDeadline;
import com.example.nguyentrunghieu_th03575.entity.TaskStatus;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DonHangRequest {
    @NotBlank(message = "Mã đơn hàng không được để trống")
    @Size(min = 3, max = 10, message = "Mã đơn hàng phải từ 3-10 ký tự")
    private String maDonHang;

    @NotNull(message = "Số lượng không được để trống")
    @Min(value = 1, message = "Số lượng phải lớn hơn 0")
    private Double soLuong;
    @FutureOrPresent(message = "Ngày đặt không được là ngày trong quá khứ")
    @ValidDeadline
    private LocalDate ngayDat;
    private String trangThai;
    private String ghiChu;

    @NotNull(message = "Vui lòng chọn sản phẩm (Dự án)")
    private Long sanPhamId;

    @NotNull(message = "Vui lòng gán nhân sự thực hiện")
    private Long userId;

    private TaskStatus taskStatus;
}
