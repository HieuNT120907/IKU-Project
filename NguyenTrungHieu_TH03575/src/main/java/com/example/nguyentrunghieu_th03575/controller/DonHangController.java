package com.example.nguyentrunghieu_th03575.controller;

import com.example.nguyentrunghieu_th03575.dto.ApiRespone;
import com.example.nguyentrunghieu_th03575.dto.DonHangRequest;
import com.example.nguyentrunghieu_th03575.dto.DonHangRespone;
import com.example.nguyentrunghieu_th03575.entity.TaskStatus;
import com.example.nguyentrunghieu_th03575.service.DonHangService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/donhangs")
@RequiredArgsConstructor
public class DonHangController {
    @Autowired
    private final DonHangService donHangService;
    @GetMapping
    public ResponseEntity<List<DonHangRespone>> findAll() {
        List<DonHangRespone> list = donHangService.findAll();
        ApiRespone<List<DonHangRespone>> respone = ApiRespone.<List<DonHangRespone>>builder()
                .code(200)
                .message("Lấy danh sách đơn hàng thành công")
                .data(list).build();

        return ResponseEntity.status(HttpStatus.OK).body(donHangService.findAll());
    }
    @GetMapping("{id}")
    public ResponseEntity<DonHangRespone> findById(@PathVariable long id) {
        DonHangRespone data = donHangService.findById(id);

        ApiRespone<DonHangRespone> response = ApiRespone.<DonHangRespone>builder()
                .code(200)
                .message("Tìm thấy đơn hàng")
                .data(data)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(donHangService.findById(id));
    }
    @PostMapping
    public ResponseEntity<DonHangRespone> save(@Valid @RequestBody DonHangRequest donHangRequest) {
        DonHangRespone savedData = donHangService.save(donHangRequest);

        ApiRespone<DonHangRespone> response = ApiRespone.<DonHangRespone>builder()
                .code(201)
                .message("Tạo đơn hàng thành công")
                .data(savedData)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(donHangService.save(donHangRequest));
    }
    @PutMapping("{id}")
    public ResponseEntity<DonHangRespone> update(@PathVariable long id,@Valid @RequestBody DonHangRequest donHangRequest) {
        DonHangRespone updatedData = donHangService.update(id, donHangRequest);

        ApiRespone<DonHangRespone> response = ApiRespone.<DonHangRespone>builder()
                .code(200)
                .message("Cập nhật đơn hàng thành công")
                .data(updatedData)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(donHangService.update(id, donHangRequest));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<DonHangRespone> delete(@PathVariable long id) {
        donHangService.delete(id);
        ApiRespone<Void> response = ApiRespone.<Void>builder()
                .code(200)
                .message("Xóa đơn hàng thành công")
                .build();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PatchMapping("/{taskId}/assign/{userId}")
    public ResponseEntity<DonHangRespone> assign(@Valid @PathVariable long taskId, @PathVariable long userId) {
        DonHangRespone assignedData = donHangService.assignTask(taskId, userId);

        ApiRespone<DonHangRespone> response = ApiRespone.<DonHangRespone>builder()
                .code(200)
                .message("Gán nhân sự thành công")
                .data(assignedData)
                .build();
        return ResponseEntity.ok(donHangService.assignTask(taskId, userId));
    }

    @GetMapping("/filter-status")
   public ResponseEntity<List<DonHangRespone>> findByStatus(@RequestParam TaskStatus status) {
        List<DonHangRespone> list = donHangService.findByStatus(status);
        ApiRespone<List<DonHangRespone>> response = ApiRespone.<List<DonHangRespone>>builder()
                .code(200)
                .message("Lọc danh sách theo trạng thái thành công")
                .data(list)
                .build();
        return ResponseEntity.ok(donHangService.findByStatus(status));
    }
    @PatchMapping("/{id}/status")
    public ResponseEntity<DonHangRespone> updateStatus(@PathVariable long id,@Valid @RequestParam TaskStatus status) {
        DonHangRespone updatedData = donHangService.updateStatus(id, status);

        ApiRespone<DonHangRespone> response = ApiRespone.<DonHangRespone>builder()
                .code(200)
                .message("Cập nhật trạng thái thành công")
                .data(updatedData)
                .build();
        return ResponseEntity.ok(donHangService.updateStatus(id, status));
    }
    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<DonHangRespone>> findAllByProject(@PathVariable long projectId) {
        List<DonHangRespone> list = donHangService.findBySanPhamId(projectId);

        ApiRespone<List<DonHangRespone>> response = ApiRespone.<List<DonHangRespone>>builder()
                .code(200)
                .message("Lấy danh sách task theo dự án thành công")
                .data(list)
                .build();
        return ResponseEntity.ok(donHangService.findBySanPhamId(projectId));
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<DonHangRespone>> findAllByUser(@PathVariable long userId) {
        List<DonHangRespone> list = donHangService.findByUserId(userId);

        ApiRespone<List<DonHangRespone>> response = ApiRespone.<List<DonHangRespone>>builder()
                .code(200)
                .message("Lấy danh sách task theo nhân sự thành công")
                .data(list)
                .build();
        return  ResponseEntity.ok(donHangService.findByUserId(userId));
    }

}
