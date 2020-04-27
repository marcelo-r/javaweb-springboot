package com.unipe.springproject.rest;

import com.unipe.springproject.domain.Department;

import java.util.List;
import java.util.Optional;

public interface CRUD<T> {

    List<T> findAll();
    Optional<T> save(T obj);
    Optional<T> findById(long id);
    void delete(T obj);
    Optional<T> update(Long id, T obj);
}
