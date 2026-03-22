package com.example.nguyentrunghieu_th03575.dto;

import com.example.nguyentrunghieu_th03575.entity.SanPham;
import com.example.nguyentrunghieu_th03575.enums.TaskStatus;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DonHangRequest {
    @NotBlank(message = "Mã đơn hàng không được để trống")
    private String maDonHang;

    @Min(value = 1, message = "Số lượng phải lớn hơn 0")
    private Double soLuong;

    private Date ngayDat;
    private String trangThai;
    private String ghiChu;

    @NotNull(message = "Phải chọn Sản phẩm/Dự án")
    private Long sanPhamId;

    @NotNull(message = "Phải gán cho một Nhân sự")
    private Long userId;

    private TaskStatus taskStatus;
}
