package com.example.nguyentrunghieu_th03575.controller;

import com.example.nguyentrunghieu_th03575.dto.DonHangRequest;
import com.example.nguyentrunghieu_th03575.dto.DonHangRespone;
import com.example.nguyentrunghieu_th03575.entity.DonHang;
import com.example.nguyentrunghieu_th03575.enums.TaskStatus;
import com.example.nguyentrunghieu_th03575.service.DonHangService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
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
        return ResponseEntity.status(HttpStatus.OK).body(donHangService.findAll());
    }
    @GetMapping("{id}")
    public ResponseEntity<DonHangRespone> findById(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(donHangService.findById(id));
    }
    @PostMapping
    public ResponseEntity<DonHangRespone> save(@RequestBody DonHangRequest donHangRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(donHangService.save(donHangRequest));
    }
    @PutMapping("{id}")
    public ResponseEntity<DonHangRespone> update(@PathVariable long id, @RequestBody DonHangRequest donHangRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(donHangService.update(id, donHangRequest));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<DonHangRespone> delete(@PathVariable long id) {
        donHangService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PatchMapping("/{taskId}/assign/{userId}")
    public ResponseEntity<DonHangRespone> assign(@PathVariable long taskId, @PathVariable long userId) {
        return ResponseEntity.ok(donHangService.assignTask(taskId, userId));
    }

    @GetMapping("/filter-status")
   public ResponseEntity<List<DonHangRespone>> findByStatus(@RequestParam TaskStatus status) {
        return ResponseEntity.ok(donHangService.findByStatus(status));
    }
    @PatchMapping("/{id}/status")
    public ResponseEntity<DonHangRespone> updateStatus(@PathVariable long id, @RequestParam TaskStatus status) {
        return ResponseEntity.ok(donHangService.updateStatus(id, status));
    }
    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<DonHangRespone>> findAllByProject(@PathVariable long projectId) {
        return ResponseEntity.ok(donHangService.findBySanPhamId(projectId));
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<DonHangRespone>> findAllByUser(@PathVariable long userId) {
        return  ResponseEntity.ok(donHangService.findByUserId(userId));
    }

}
