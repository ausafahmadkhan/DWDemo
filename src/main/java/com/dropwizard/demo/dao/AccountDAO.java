package com.dropwizard.demo.dao;

import com.dropwizard.demo.entity.Account;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

@Singleton
public class AccountDAO extends AbstractDAO<Account> {

    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    @Inject
    public AccountDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }


    /**
     * @param account to be persisted
     */
    public void save(Account account)
    {
        persist(account);
    }


    /**
     * @param id account id
     * @return Account
     */
    public Account findById(String id)
    {
       return get(id);
    }
}
