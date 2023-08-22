package com.dmdev.application.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<I, T> {

    List<T> findAll();

    Optional<T> findById(I id);

    boolean delete(I id);

    void update(T entity);

    T save(T entity);
}
