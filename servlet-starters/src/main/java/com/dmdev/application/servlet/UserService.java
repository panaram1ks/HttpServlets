package com.dmdev.application.servlet;

import com.dmdev.application.dao.UserDao;
import com.dmdev.application.dto.CreateUserDto;
import com.dmdev.application.entity.User;
import com.dmdev.application.exception.ValidationException;
import com.dmdev.application.mapper.CreateUserMapper;
import com.dmdev.application.validator.CreateUserValidator;
import com.dmdev.application.validator.ValidationResult;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {
    private static final UserService INSTANCE = new UserService();
    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();


    public Integer create(CreateUserDto userDto) {
        // validation
        ValidationResult validationResult = createUserValidator.isValid(userDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }
        // map
        User user = createUserMapper.mapFrom(userDto);
        //userDao.save
        userDao.save(user);
        return user.getId();
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}