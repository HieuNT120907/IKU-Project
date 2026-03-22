package com.example.nguyentrunghieu_th03575.service.impl;
import com.example.nguyentrunghieu_th03575.dto.UserRequest;
import com.example.nguyentrunghieu_th03575.dto.UserResponse;
import com.example.nguyentrunghieu_th03575.entity.User;
import com.example.nguyentrunghieu_th03575.exception.CustomDuplicateResource;
import com.example.nguyentrunghieu_th03575.repository.UserRepo;
import com.example.nguyentrunghieu_th03575.service.UserService;
import com.example.nguyentrunghieu_th03575.exception.CustomResourceNotFound;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  java.lang.Override;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceimpl implements UserService {
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;


    @Override
    public List<UserResponse> findAllUsers() {
        return userRepo.findAll().stream().map(user -> modelMapper.map(user, UserResponse.class)).toList();
    }

    @Override
    public UserResponse findUserById(long id) {
        return userRepo.findById(id).map(user -> modelMapper.map(user, UserResponse.class))
                .orElseThrow(()-> new CustomResourceNotFound("User not found with id " + id));
    }

    @Override
    public UserResponse add(UserRequest userRequest) {
        if (userRepo.existsByUsername(userRequest.getUsername())) {
            throw new CustomDuplicateResource("Username đã tồn tại!");
        }
        User user = modelMapper.map(userRequest, User.class);
        User savedUser = userRepo.save(user);
        return modelMapper.map(savedUser, UserResponse.class);
    }

    @Override
    public UserResponse update(UserRequest userRequest, long id) {
        User existingUser = userRepo.findById(id)
                .orElseThrow(() -> new CustomResourceNotFound("Không tìm thấy User với id: " + id));

        // Kiểm tra trùng lặp Username khi cập nhật (Trừ chính nó)
        if (userRepo.existsByUsernameAndIdNot(userRequest.getUsername(), id)) {
            throw new CustomDuplicateResource("Username đã tồn tại!");
        }

        // Map dữ liệu từ Request vào Entity hiện tại
        modelMapper.map(userRequest, existingUser);
        existingUser.setId(id); // Đảm bảo ID không thay đổi

        User updatedUser = userRepo.save(existingUser);
        return modelMapper.map(updatedUser, UserResponse.class);
    }

    @Override
    public void delete(long id) {
        userRepo.findById(id).orElseThrow(()->new CustomResourceNotFound("User not found with id " + id));
        userRepo.deleteById(id);
    }
}
