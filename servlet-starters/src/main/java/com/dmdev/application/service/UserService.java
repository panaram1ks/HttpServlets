package com.dmdev.application.service;

import com.dmdev.application.dao.UserDao;
import com.dmdev.application.dto.CreateUserDto;
import com.dmdev.application.dto.UserDto;
import com.dmdev.application.entity.User;
import com.dmdev.application.exception.ValidationException;
import com.dmdev.application.mapper.CreateUserMapper;
import com.dmdev.application.mapper.UserMapper;
import com.dmdev.application.validator.CreateUserValidator;
import com.dmdev.application.validator.ValidationResult;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {
    private static final UserService INSTANCE = new UserService();
    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();
    private final ImageService imageService = ImageService.getInstance();
    private final UserMapper userMapper = UserMapper.getInstance();

    public Optional<UserDto> login(String email, String password){
        return  userDao.findByEmailAndPassword(email, password)
                .map(userMapper::mapFrom);
    }

    @SneakyThrows
    public Integer create(CreateUserDto userDto) {
        // validation
        ValidationResult validationResult = createUserValidator.isValid(userDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }
        // map
        User user = createUserMapper.mapFrom(userDto);
        //userDao.save
        imageService.upload(user.getImage(), userDto.getImage().getInputStream());
        userDao.save(user);
        return user.getId();
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
