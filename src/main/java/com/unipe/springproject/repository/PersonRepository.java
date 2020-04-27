package com.unipe.springproject.repository;

import com.unipe.springproject.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
