package com.unipe.springproject.services;

import java.util.List;
import java.util.Optional;

public interface CRUD<T> {

    List<T> findAll();
    T save(T obj);
    Optional<T> findById(Long id);
    void delete(T obj);
    T update(Long id, T obj);
}
