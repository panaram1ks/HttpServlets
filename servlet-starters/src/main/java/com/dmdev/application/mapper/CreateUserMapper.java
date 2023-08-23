package com.dmdev.application.mapper;

import com.dmdev.application.dto.CreateUserDto;
import com.dmdev.application.entity.Gender;
import com.dmdev.application.entity.Role;
import com.dmdev.application.entity.User;
import com.dmdev.application.util.LocalDateFormatter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateUserMapper  implements Mapper<CreateUserDto, User>{

    private static final String IMAGE_FOLDER = "users/";

    private static final CreateUserMapper INSTANCE = new CreateUserMapper();

    @Override
    public User mapFrom(CreateUserDto object) {
        return User.builder()
                .name(object.getName())
                .image(IMAGE_FOLDER + object.getImage().getSubmittedFileName())
                .email(object.getEmail())
                .password(object.getPassword())
                .gender(Gender.valueOf(object.getGender()))
                .role(Role.valueOf(object.getRole()))
                .birthday(LocalDateFormatter.format(object.getBirthday()))
                .build();
    }

    public static CreateUserMapper getInstance(){
        return INSTANCE;
    }

}
