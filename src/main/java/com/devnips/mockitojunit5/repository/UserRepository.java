package com.devnips.mockitojunit5.repository;

import com.devnips.mockitojunit5.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Long, User> {
}
