package com.devnips.mockitojunit5.service;

import com.devnips.mockitojunit5.model.Person;
import com.devnips.mockitojunit5.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PersonServiceTest {

    /**
     * Verify successful execution of tested method, by setting dependency method to do nothing.
     */
    @Test
    void create_success() {
        // Create mock of PersonRepository
        PersonRepository mockPersonRepository = Mockito.mock(PersonRepository.class);

        // Create PersonService class and inject mocked PersonRepository object to it.
        PersonService personService = new PersonService(mockPersonRepository);

        // Setup do nothing expectation of PersonRepository
        Mockito.doNothing().when(mockPersonRepository).delete(Mockito.any(Person.class));

        // Call tested method
        personService.delete(34L);

        // Verify that delete() method of PersonRepository was called by the delete() method od PersonService.
        Mockito.verify(mockPersonRepository).delete(Mockito.any(Person.class));
    }

    /**
     * Verify exception is throw by the tested method if dependent method throws exception.
     */
    @Test
    void create_exception() {
        // Create mock of PersonRepository
        PersonRepository mockPersonRepository = Mockito.mock(PersonRepository.class);

        // Create PersonService class and inject mocked PersonRepository object to it.
        PersonService personService = new PersonService(mockPersonRepository);

        // Setup expectation of delete() method of PersonRepository to throw exception
        Mockito.doThrow(new RuntimeException("Invalid Argument")).when(mockPersonRepository).delete(Mockito.any(Person.class));

        // Call tested method, and verify that it throws an exception
        Assertions.assertThrows(RuntimeException.class, () -> personService.delete(100L));
    }
}