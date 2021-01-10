package com.devnips.mockitojunit5.service;

import com.devnips.mockitojunit5.model.User;
import com.devnips.mockitojunit5.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.Optional;

/**
 * Here we create a simple mock object from Mockito and define default Answer for that mock object.
 */
class UserServiceMockWithAnswerTest {

    @Test
    void simple_mock() {
        // Create a mock object and set default answer for all methods.
        // This Answer implementation will be invoked if no expectation is defined for a method.
        UserRepository mockedUserRepository =
                Mockito.mock(UserRepository.class, new Answer() {
                    @Override
                    public Object answer(InvocationOnMock invocationOnMock) {
                        return Optional.of(new User(200L));
                    }
                });

        // Inject mock implementation of UserRepository as dependency to UserService method.
        UserService userService = new UserService(mockedUserRepository);

        // When the tested method is invoked.
        Optional<User> result = userService.findById(100L);

        // Then the default User object defined during creation of mock should be returned.
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(200L, result.get().getId());

        // define custom response for the findById() method of UserRepository mock object.
        // This will override the default Answer implementation.
        Mockito.doReturn(Optional.of(new User(100L)))
                .when(mockedUserRepository)
                .findById(100L);

        // Now when the tested method is invoked.
        Optional<User> customResult = userService.findById(100L);

        // Then the custom User object defined in doReturn method should be returned.
        Assertions.assertTrue(customResult.isPresent());
        Assertions.assertEquals(100L, customResult.get().getId());
    }
}