package com.testcontainers.springkafka.service;

import com.testcontainers.springkafka.dto.User;

import java.util.List;

public interface UserService {

    void save(User user);

    List<com.testcontainers.springkafka.entity.User> getUsers(String firstName);

    List<com.testcontainers.springkafka.entity.User> findAllUsers();
}
