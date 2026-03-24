package com.example.nguyentrunghieu_th03575.service;

import com.example.nguyentrunghieu_th03575.dto.UserRequest;
import com.example.nguyentrunghieu_th03575.dto.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> findAllUsers();
    UserResponse findUserById(long id);
    UserResponse add(UserRequest userRequest);
    UserResponse update(UserRequest userRequest,long id);
    void delete(long id);
}
