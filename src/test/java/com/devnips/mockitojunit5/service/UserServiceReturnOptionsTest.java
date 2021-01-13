package com.devnips.mockitojunit5.service;

import com.devnips.mockitojunit5.model.User;
import com.devnips.mockitojunit5.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

/**
 * Test class to show example implementation of when-thenReturn and doReturn-when pattern of Mockito to define return
 * types from a mocked method.
 */
class UserServiceReturnOptionsTest {

    /**
     * This method used when-thenReturn pattern to set return value from a mock object
     */
    @Test
    void when_then_example() {
        // Create a mock object for dependency class
        UserRepository mockUserRepository = Mockito.mock(UserRepository.class);

        // Add mocked dependency to the class object being tested
        UserService userService = new UserService(mockUserRepository);

        // Use when-thenReturn format to specify return value for invoked method on mock
        Mockito.when(mockUserRepository.findById(100L)).thenReturn(Optional.of(new User(100L)));

        // Invoke the method to be tested
        Optional<User> userOptional = userService.findById(100L);

        // Check return value is as expected
        Assertions.assertTrue(userOptional.isPresent());
        Assertions.assertEquals(100L, userOptional.get().getId());
    }

    /**
     * This method used doReturn-when pattern to set return value from a mock object
     */
    @Test
    void doReturn_when_example() {
        // Create a mock object for dependency class
        UserRepository mockUserRepository = Mockito.mock(UserRepository.class);

        // Add mocked dependency to the class object being tested
        UserService userService = new UserService(mockUserRepository);

        // Use doReturn-when format to specify return value for invoked method on mock
        Mockito.doReturn(Optional.of(new User(200L))).when(mockUserRepository).findById(200L);

        // Invoke the method to be tested
        Optional<User> userOptional = userService.findById(200L);

        // Check return value is as expected
        Assertions.assertTrue(userOptional.isPresent());
        Assertions.assertEquals(200L, userOptional.get().getId());
    }
}
