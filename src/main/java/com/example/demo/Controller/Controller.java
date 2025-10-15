package com.example.demo.Controller;

import com.example.demo.dto.CreateUserDto;
import com.example.demo.entity.User;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class Controller {

    @Autowired
    TestService testService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody CreateUserDto userDto) {
        testService.createUser(userDto);
    }

    @DeleteMapping("/{user-id}")
    public void deleteUser(@PathVariable("user-id") Long parameter) {
        testService.deleteUser(parameter);
    }

    @GetMapping("/{user-id}")
    public Optional<User> readUser(@PathVariable("user-id") Long parameter) {
        return testService.readUser(parameter);
    }

    @PutMapping("/{user-id}")
    public void updateUser(@PathVariable("user-id") Long parameter, @RequestBody CreateUserDto userDto) {
        testService.updateUser(parameter,userDto);
    }
}
