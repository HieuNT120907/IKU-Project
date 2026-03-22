package com.example.nguyentrunghieu_th03575.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "san_phams")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ten;
    private String ma;
    private String nhaSanXuat;
    private BigDecimal gia;
    private String ghiChu;
    @OneToMany(mappedBy = "sanPham", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<DonHang> donHangs;
}
