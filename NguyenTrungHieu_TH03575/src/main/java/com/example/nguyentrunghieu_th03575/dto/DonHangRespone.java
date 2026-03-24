package com.example.nguyentrunghieu_th03575.dto;

import com.example.nguyentrunghieu_th03575.entity.TaskStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter

public class DonHangRespone {
    private String maDonHang;
    private double soLuong;
    @Column(name = "ngay_dat")
    @CreationTimestamp
    private LocalDate ngayDat; // Thêm trường này để khớp với data.sql
    private String ghiChu;
    private TaskStatus trangThai; // Dùng Enum để đồng bộ với Rule

    // Thông tin lấy từ SanPhamEntity thông qua ModelMapper
    private String sanPhamTen;
    private String nhaSanXuat; // Thêm để đa dạng thông tin Project

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal sanPhamGia;
}
