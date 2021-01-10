package com.devnips.mockitojunit5.service;

import com.devnips.mockitojunit5.model.User;
import com.devnips.mockitojunit5.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class UserServiceNoMockitoTest {

    private UserService userService;

    private MockUserRepository mockUserRepository = new MockUserRepository();

    @Test
    void findOneById_valid_id() {
        // Setup dummy behaviour
        userService = new UserService(new MockUserRepository() {
            @Override
            public Optional<User> findById(Long id) {
                if (id == 100L) {
                    return Optional.of(new User(id));
                } else {
                    return Optional.empty();
                }
            }
        });

        // When test method is called
        Optional<User> optionalUser = userService.findById(100L);

        // Then we should get non empty value
        Assertions.assertTrue(optionalUser.isPresent());
    }

    /**
     * Creating a dummy implementation of UserRepository.
     */
    class MockUserRepository implements UserRepository {

        @Override
        public List<User> findAll() {
            return null;
        }

        @Override
        public List<User> findAll(Sort sort) {
            return null;
        }

        @Override
        public Page<User> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public List<User> findAllById(Iterable<Long> iterable) {
            return null;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Long aLong) {

        }

        @Override
        public void delete(User user) {

        }

        @Override
        public void deleteAll(Iterable<? extends User> iterable) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends User> S save(S s) {
            return null;
        }

        @Override
        public <S extends User> List<S> saveAll(Iterable<S> iterable) {
            return null;
        }

        @Override
        public Optional<User> findById(Long aLong) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends User> S saveAndFlush(S s) {
            return null;
        }

        @Override
        public void deleteInBatch(Iterable<User> iterable) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public User getOne(Long aLong) {
            return null;
        }

        @Override
        public <S extends User> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends User> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends User> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends User> boolean exists(Example<S> example) {
            return false;
        }
    }
}