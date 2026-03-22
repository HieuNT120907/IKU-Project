package com.example.nguyentrunghieu_th03575.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    @NotBlank(message = "Username không được để trống")
    @Size(min = 5, max = 50, message = "Username phải từ 5 đến 50 ký tự")
    @Column(unique = true, nullable = false)
    private String username;

    @NotBlank(message = "Password không được để trống")
    @Size(min = 6, message = "Password phải có ít nhất 6 ký tự")
    @Column(nullable = false)
    private String password;

    @NotBlank(message = "Họ tên không được để trống")
    @Size(min = 3, max = 30, message = "Họ tên phải từ 3-30 ký tự")
    private String fullName;

    @NotBlank(message = "Role không được để trống")
    private String role;


}
