package com.example.nguyentrunghieu_th03575.repository;

import com.example.nguyentrunghieu_th03575.entity.DonHang;
import com.example.nguyentrunghieu_th03575.enums.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonHangRepo extends JpaRepository<DonHang, Long> {
    List<DonHang> findByTaskStatus(TaskStatus status);
}
