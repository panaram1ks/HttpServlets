package com.dmdev.application.dto;

import com.dmdev.application.entity.Gender;
import com.dmdev.application.entity.Role;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class UserDto {
    Integer id;
    String email;
    String name;
    LocalDate birthday;
    String image;
    Role role;
    Gender gender;
}
