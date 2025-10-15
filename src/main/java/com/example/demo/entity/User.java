package com.example.demo.entity;

import com.example.demo.dto.CreateUserDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // 입력 없을 때 막는거 찾아보기
    private String title;

    private String contents;

    public User(CreateUserDto userDto) {
        this.title = userDto.getTitle();
        this.contents = userDto.getContents();
    }
}
