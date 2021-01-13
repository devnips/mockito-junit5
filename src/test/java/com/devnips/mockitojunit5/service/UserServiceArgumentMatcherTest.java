package com.devnips.mockitojunit5.service;

import com.devnips.mockitojunit5.model.User;
import com.devnips.mockitojunit5.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

/**
 * In this example we will use ArgumentMatchers to verify the values passed to a mock method as parameters.
 */
class UserServiceArgumentMatcherTest {

    @Test
    void verify_argument() {
        // Create a mock object for dependency class
        UserRepository mockUserRepository = Mockito.mock(UserRepository.class);

        // Add mocked dependency to the class object being tested
        UserService userService = new UserService(mockUserRepository);

        // Use when-thenReturn format to specify return value for invoked method on mock
        Mockito.when(mockUserRepository.findById(100L)).thenReturn(Optional.of(new User(100L)));

        // Invoke the method to be tested
        userService.findById(100L);

        // Verify that we have called findById() method of UserRepository with correct arguments
        Mockito.verify(mockUserRepository).findById(Mockito.argThat((Long id) -> id == 100L));
    }
}