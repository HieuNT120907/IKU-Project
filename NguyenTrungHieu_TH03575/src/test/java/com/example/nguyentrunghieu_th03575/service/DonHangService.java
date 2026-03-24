package com.example.nguyentrunghieu_th03575.service;

import com.example.nguyentrunghieu_th03575.dto.DonHangRequest;
import com.example.nguyentrunghieu_th03575.dto.DonHangRespone;
import com.example.nguyentrunghieu_th03575.entity.TaskStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DonHangService {
    List<DonHangRespone> findAll();
    DonHangRespone findById(long id);
    DonHangRespone save(DonHangRequest donHangRequest);
    DonHangRespone update(long id,DonHangRequest donHangRequest);
    void delete(Long id);
    DonHangRespone assignTask(long taskId, long userId);
    List<DonHangRespone> findByStatus(TaskStatus taskStatus);
    DonHangRespone updateStatus(long id, TaskStatus newStatus);
    List<DonHangRespone> findBySanPhamId(Long sanPhamId);
    List<DonHangRespone> findByUserId(Long userId);
}
