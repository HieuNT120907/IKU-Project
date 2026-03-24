package com.example.nguyentrunghieu_th03575.service.impl;

import com.example.nguyentrunghieu_th03575.dto.DonHangRequest;
import com.example.nguyentrunghieu_th03575.dto.DonHangRespone;
import com.example.nguyentrunghieu_th03575.entity.DonHang;
import com.example.nguyentrunghieu_th03575.entity.SanPham;
import com.example.nguyentrunghieu_th03575.entity.TaskStatus;
import com.example.nguyentrunghieu_th03575.entity.User;
import com.example.nguyentrunghieu_th03575.exception.CustomResourceNotFound;
import com.example.nguyentrunghieu_th03575.repository.DonHangRepo;
import com.example.nguyentrunghieu_th03575.repository.SanPhamRepo;
import com.example.nguyentrunghieu_th03575.repository.UserRepo;
import com.example.nguyentrunghieu_th03575.service.DonHangService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DonHangServiceimpl implements DonHangService {
    private final DonHangRepo donHangRepo;
    private final SanPhamRepo sanPhamRepo;
    private final ModelMapper modelMapper;
    private final UserRepo userRepo;

    @Override
    public List<DonHangRespone> findAll() {
        return donHangRepo.findAll().stream().map(entity -> modelMapper.map(entity, DonHangRespone.class)).toList();

    }

    @Override
    public DonHangRespone findById(long id) {
        return donHangRepo.findById(id).map(entity -> modelMapper.map(entity, DonHangRespone.class)).orElseThrow(()->
                new CustomResourceNotFound("DonHangRespone not found"+id));
    }

    @Override
    public DonHangRespone save(DonHangRequest donHangRequest) {
        DonHang donHang = modelMapper.map(donHangRequest, DonHang.class);
        SanPham sanPham = sanPhamRepo.findById(donHangRequest.getSanPhamId()).orElseThrow(
                () -> new CustomResourceNotFound("SanPham not found" + donHang.getSanPham().getId())
        );
        if (donHangRequest.getUserId() != null) {
            User user = userRepo.findById(donHangRequest.getUserId())
                    .orElseThrow(() -> new CustomResourceNotFound("Không tìm thấy User với ID: " + donHangRequest.getUserId()));
            donHang.setUser(user);
        }
        donHang.setSanPham(sanPham);
        donHang.setId(null);
        donHangRepo.save(donHang);
        return modelMapper.map(donHang, DonHangRespone.class);
    }

    @Override
    public DonHangRespone update(long id, DonHangRequest donHangRequest) {
        return donHangRepo.findById(id).map(e -> {

            if (e.getTaskStatus() == TaskStatus.DONE) {
                throw new RuntimeException("Task đã hoàn thành (DONE), không thể chỉnh sửa thông tin!");
            }

            // Cập nhật các trường cơ bản nếu có thay đổi
            if (donHangRequest.getMaDonHang() != null) e.setMaDonHang(donHangRequest.getMaDonHang());
            if (donHangRequest.getSoLuong() != 0d) e.setSoLuong(donHangRequest.getSoLuong());
            if (donHangRequest.getNgayDat() != null) e.setNgayDat(LocalDate.now());
            if (donHangRequest.getGhiChu() != null) e.setGhiChu(donHangRequest.getGhiChu());

            // RULE 2: Cập nhật trạng thái (Task Status Flow: TODO -> IN_PROGRESS -> DONE)
            if (donHangRequest.getTaskStatus() != null) {
                // Logic: Chặn không cho chuyển ngược từ IN_PROGRESS về TODO (tùy nghiệp vụ)
                e.setTaskStatus(donHangRequest.getTaskStatus());
            }

            // RULE 3: Cập nhật Project (Sản phẩm)
            if (donHangRequest.getSanPhamId() != null) {
                e.setSanPham(sanPhamRepo.findById(donHangRequest.getSanPhamId())
                        .orElseThrow(() -> new CustomResourceNotFound("Sản phẩm không tìm thấy với id: " + donHangRequest.getSanPhamId())));
            }

            // RULE 4: Cập nhật Assign (Người thực hiện)
            if (donHangRequest.getUserId() != null) {
                e.setUser(userRepo.findById(donHangRequest.getUserId())
                        .orElseThrow(() -> new CustomResourceNotFound("Người dùng không tìm thấy với id: " + donHangRequest.getUserId())));
            }

            // Lưu lại thực thể sau khi đã cập nhật đủ các Rule
            donHangRepo.save(e);

            // Trả về DTO (Đã xử lý BigDecimal trong ModelMapper)
            return modelMapper.map(e, DonHangRespone.class);
        }).orElseThrow(() -> new CustomResourceNotFound("Đơn hàng NOT FOUND với id: " + id));
    }

    @Override
    public void delete(Long id) {
        donHangRepo.findById(id).orElseThrow(()-> new CustomResourceNotFound("Don Hang not found"+id));
        donHangRepo.deleteById(id);
    }

    @Override
    public DonHangRespone assignTask(long taskId, long userId) {
        DonHang donHang = donHangRepo.findById(taskId).orElseThrow(
                () -> new CustomResourceNotFound("Không tìm thấy Task với ID:" + taskId));
        User user = userRepo.findById(userId).orElseThrow(
                () -> new CustomResourceNotFound("Không tìm thấy User với ID: " + userId));
        Long projectIdOfTask = donHang.getSanPham().getId();
        donHang.setUser(user);
        DonHang updatedTask = donHangRepo.save(donHang);
        return modelMapper.map(updatedTask, DonHangRespone.class);
    }

    @Override
    public List<DonHangRespone> findByStatus(TaskStatus taskStatus) {
        List<DonHang> list = donHangRepo.findByTaskStatus(taskStatus);
        return list.stream().map(entity -> modelMapper.map(entity, DonHangRespone.class)).toList();
    }


    @Override
    public DonHangRespone updateStatus(long id, TaskStatus newStatus) {
        DonHang donHang = donHangRepo.findById(id).orElseThrow(
                () -> new CustomResourceNotFound("Không tìm thấy Task ID:"+id));
        if (donHang.getTaskStatus() == TaskStatus.DONE) {
            throw new RuntimeException("Task đã hoàn thành (DONE), không thể cập nhật trạng thái mới!");
        }
        donHang.setTaskStatus(newStatus);
        return modelMapper.map(donHangRepo.save(donHang), DonHangRespone.class);
    }

    @Override
    public List<DonHangRespone> findBySanPhamId(Long sanPhamId) {
        return donHangRepo.findById(sanPhamId).stream()
                .map(e ->modelMapper.map(e, DonHangRespone.class))
                .toList();
    }

    @Override
    public List<DonHangRespone> findByUserId(Long userId) {
        return donHangRepo.findById(userId).stream()
                .map(e-> modelMapper.map(e, DonHangRespone.class))
                .toList();
    }


}
