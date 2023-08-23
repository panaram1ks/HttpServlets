package com.dmdev.application.mapper;

public interface Mapper<F, T> {

    T mapFrom(F object);
}
