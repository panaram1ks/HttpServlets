package com.dmdev.application.validator;

public interface Validator<T> {

    ValidationResult isValid(T object);

}
