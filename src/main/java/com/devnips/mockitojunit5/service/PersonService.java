package com.devnips.mockitojunit5.service;

import com.devnips.mockitojunit5.model.Person;
import com.devnips.mockitojunit5.repository.PersonRepository;

public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void delete(Long id) {
        Person person = new Person();
        person.setId(id);
        personRepository.delete(person);
    }
}
