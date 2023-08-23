package com.dmdev.application.validator;

import com.dmdev.application.dto.CreateUserDto;
import com.dmdev.application.entity.Gender;
import com.dmdev.application.util.LocalDateFormatter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateUserValidator implements Validator<CreateUserDto> {

    private final static CreateUserValidator INSTANCE = new CreateUserValidator();

    @Override
    public ValidationResult isValid(CreateUserDto object) {
        ValidationResult validationResult = new ValidationResult();
        if (object.getGender() == null || Gender.valueOf(object.getGender()) == null) {
            validationResult.add(Error.of("invalid.gender", "Gender is invalid"));
        }
        if (!LocalDateFormatter.isValid(object.getBirthday())) {
            validationResult.add(Error.of("invalid.birthday", "Birthday is invalid"));
        }

        return validationResult;
    }

    public static CreateUserValidator getInstance() {
        return INSTANCE;
    }
}
