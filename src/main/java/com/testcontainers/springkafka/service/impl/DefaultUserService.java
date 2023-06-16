package com.testcontainers.springkafka.service.impl;

import com.testcontainers.springkafka.dto.User;
import com.testcontainers.springkafka.repository.UserRepository;
import com.testcontainers.springkafka.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultUserService implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(DefaultUserService.class);

    private final UserRepository userRepository;

    public DefaultUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user) {
        logger.info("Saving user with id = {}", user.getUuid());
        userRepository.save(new com.testcontainers.springkafka.entity.User(user.getUuid(), user.getFirstName(), user.getLastName()));
    }

    @Override
    public List<com.testcontainers.springkafka.entity.User> getUsers(String firstName) {
        return userRepository.getByFirstNameIgnoreCaseOrderByFirstNameAscLastNameAsc(firstName);
    }

    @Override
    public List<com.testcontainers.springkafka.entity.User> findAllUsers() {
        return userRepository.findAll();
    }
}
