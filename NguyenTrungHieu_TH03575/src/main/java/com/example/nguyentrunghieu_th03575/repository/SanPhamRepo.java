package com.example.nguyentrunghieu_th03575.repository;

import com.example.nguyentrunghieu_th03575.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamRepo extends JpaRepository<SanPham, Long> {
}
