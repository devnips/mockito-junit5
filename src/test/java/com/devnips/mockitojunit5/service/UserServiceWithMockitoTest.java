package com.devnips.mockitojunit5.service;

import com.devnips.mockitojunit5.model.User;
import com.devnips.mockitojunit5.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

/**
 * This test class shows how to mock a dependency class using Mockito annotations.
 * The below @ExtendWith annotation enabled the Mockito extension, which is required for processing annotations.
 */
@ExtendWith(MockitoExtension.class)
class UserServiceWithMockitoTest {

    /**
     * @Mock is an annotation provided by Mockito that creates a dummy implementation of the given class or interface.
     * Mockito uses Java's proxy pattern to create the dummy class.
     */
    @Mock
    private UserRepository userRepository;

    /**
     * @InjectMocks is a Mockito annotations that tells Mockito to create an actual instance of the given class and
     * also inject any dependencies that are defined with @Mock annotation.
     */
    @InjectMocks
    private UserService userService;

    @Test
    void findById_existing_id() {
        // Here we are defining the behaviour of given method in our Mock implementation.
        // We are telling Mockito to return a User object when `findById()` method of userRepository object is called
        // with parameter as 100L
        Mockito.doReturn(Optional.of(new User(100L)))
                .when(userRepository)
                .findById(100L);

        // When the tested method is invoked.
        Optional<User> result = userService.findById(100L);

        // Then the defined User object should be returned.
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(100L, result.get().getId());
    }

    @Test
    void findById_non_existent_id() {
        Mockito.doReturn(Optional.empty())
                .when(userRepository)
                .findById(200L);

        Optional<User> result = userService.findById(200L);

        Assertions.assertFalse(result.isPresent());
    }
}