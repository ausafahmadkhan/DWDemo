package com.dropwizard.demo.dao;

import com.dropwizard.demo.entity.User;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

@Singleton
public class UserDAO extends AbstractDAO<User>
{

    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    @Inject
    public UserDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    /**
     *
     * @param id userid
     * @return user with that id
     */
    public User findById(String id)
    {
        return get(id);
    }


    /**
     * @param user to be persisted
     */
    public void save(User user)
    {
        persist(user);
    }
}
