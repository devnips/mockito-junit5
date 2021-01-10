package com.devnips.mockitojunit5.service;

import com.devnips.mockitojunit5.model.User;
import com.devnips.mockitojunit5.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

class UserServiceSimpleMockTest {

    @Test
    void simple_mock() {
        // Create a mock object using Mockito.
        UserRepository mockedUserRepository = Mockito.mock(UserRepository.class);

        // Inject mock implementation of UserRepository as dependency to UserService method.
        UserService userService = new UserService(mockedUserRepository);

        // define expectation from the findById() method of UserRepository mock object
        Mockito.doReturn(Optional.of(new User(100L)))
                .when(mockedUserRepository)
                .findById(100L);

        // When the tested method is invoked.
        Optional<User> result = userService.findById(100L);

        // Then the dummy User object should be returned.
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(100L, result.get().getId());
    }
}