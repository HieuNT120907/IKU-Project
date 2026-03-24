package com.example.nguyentrunghieu_th03575.controller;

import com.example.nguyentrunghieu_th03575.dto.ApiRespone;
import com.example.nguyentrunghieu_th03575.dto.AuthRequest;
import com.example.nguyentrunghieu_th03575.dto.RegisterRequest;
import com.example.nguyentrunghieu_th03575.entity.User;
import com.example.nguyentrunghieu_th03575.repository.UserRepo;
import com.example.nguyentrunghieu_th03575.security.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder; // Thằng này dùng để băm mật khẩu (BCrypt)

    // 1. API Đăng ký tài khoản
    @PostMapping("/register")
    public ResponseEntity<ApiRespone<String>> register(@Valid @RequestBody RegisterRequest request) {
        // Kiểm tra xem username đã tồn tại chưa
        if (userRepo.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("Username đã tồn tại, vui lòng chọn tên khác!");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        // Mã hóa mật khẩu trước khi lưu vào DB
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setFullName(request.getFullName());
        user.setRole("ROLE_USER"); // Mặc định đăng ký mới là nhân viên (USER)

        userRepo.save(user);

        ApiRespone<String> response = ApiRespone.<String>builder()
                .code(200)
                .message("Đăng ký thành công!")
                .build();
        return ResponseEntity.ok(response);
    }

    // 2. API Đăng nhập và lấy JWT Token
    @PostMapping("/login")
    public ResponseEntity<ApiRespone<String>> login(@Valid @RequestBody AuthRequest request) {
        // Spring Security sẽ tự động kiểm tra username và password mã hóa
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        // Nếu pass qua được dòng trên, nghĩa là đăng nhập đúng -> Sinh Token
        String token = jwtUtil.generateToken(request.getUsername());

        ApiRespone<String> response = ApiRespone.<String>builder()
                .code(200)
                .message("Đăng nhập thành công!")
                .data(token) // Nhét chữ Token vào trong Data trả về
                .build();

        return ResponseEntity.ok(response);
    }
}
