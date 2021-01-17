package com.devnips.mockitojunit5.repository;

import com.devnips.mockitojunit5.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
