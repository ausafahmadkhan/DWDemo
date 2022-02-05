package com.dropwizard.demo.service;

import com.dropwizard.demo.entity.User;
import com.google.inject.ImplementedBy;

@ImplementedBy(UserServiceImpl.class)
public interface UserService {

    void addUser(User user);

    User getUserById(String id);
}
