package com.dropwizard.demo.service;

import com.dropwizard.demo.dao.UserDAO;
import com.dropwizard.demo.entity.User;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Inject
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    /**
     * @param user
     */
    @Override
    public void addUser(User user) {
        userDAO.save(user);
        logger.info("User saved successfully...");

    }

    /**
     * @param id
     * @return
     */
    @Override
    public User getUserById(String id) {
        User user = userDAO.findById(id);
        logger.info("User fetched : " + user);
        return user;
    }
}
