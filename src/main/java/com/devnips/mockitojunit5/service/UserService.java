package com.devnips.mockitojunit5.service;

import com.devnips.mockitojunit5.model.User;
import com.devnips.mockitojunit5.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Save a user in database
     *
     * @param id
     * @return
     */
    public Optional<User> findById(Long id) {
        if (id == null) {
            throw new RuntimeException("Id is required");
        }
        return userRepository.findById(id);
    }
}
