package com.example.demo.service;

import com.example.demo.dto.CreateUserDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class TestService {
    @Autowired
    UserRepository userRepository;

    public void createUser(CreateUserDto userDto) {
        User user = new User(userDto);
        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public Optional<User> readUser(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser;
    }

    public void updateUser(Long userId, CreateUserDto userDto) {
        Optional<User> optionalUser = userRepository.findById(userId);
        optionalUser.ifPresent(selectUser->{
            selectUser.setTitle(userDto.getTitle());
            selectUser.setContents(userDto.getContents());
            userRepository.save(selectUser);
        });
    }
}
