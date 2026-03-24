package com.example.nguyentrunghieu_th03575.service;

import com.example.nguyentrunghieu_th03575.dto.DonHangRequest;
import com.example.nguyentrunghieu_th03575.entity.DonHang;
import com.example.nguyentrunghieu_th03575.entity.TaskStatus;
import com.example.nguyentrunghieu_th03575.repository.DonHangRepo;
import com.example.nguyentrunghieu_th03575.service.impl.DonHangServiceimpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DonHangServiceTest {

    @Mock
    private DonHangRepo donHangRepo; // Giả lập Repository

    @InjectMocks
    private DonHangServiceimpl donHangService; // Tiêm Mock vào Service thực tế

    private DonHang donHangDone;
    private DonHangRequest request;

    @BeforeEach
    void setUp() {
        // Giả lập một đơn hàng đã hoàn thành (DONE)
        donHangDone = new DonHang();
        donHangDone.setId(1L);
        donHangDone.setTaskStatus(TaskStatus.DONE);

        request = new DonHangRequest();
        request.setMaDonHang("DH-UPDATE");
    }

    @Test
    void update_ShouldThrowException_WhenStatusIsDone() {

        when(donHangRepo.findById(1L)).thenReturn(Optional.of(donHangDone));


        assertThrows(RuntimeException.class, () -> {
            donHangService.update(1L, request);
        });

        System.out.println("Test case: Chặn update khi DONE -> Thành công!");
    }
}