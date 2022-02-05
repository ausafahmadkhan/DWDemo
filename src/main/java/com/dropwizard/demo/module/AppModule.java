package com.dropwizard.demo.module;


import com.dropwizard.demo.configuration.MyConfig;
import com.dropwizard.demo.entity.Account;
import com.dropwizard.demo.entity.User;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import org.hibernate.SessionFactory;

public class AppModule extends AbstractModule {

    private final HibernateBundle<MyConfig> hibernateBundle = new HibernateBundle<MyConfig>(User.class, Account.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(MyConfig configuration) {
            return configuration.getDatabase();
        }
    };

    public AppModule(Bootstrap<MyConfig> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
    }

    @Provides
    public SessionFactory provideSessionFactory() {
        return hibernateBundle.getSessionFactory();
    }



}
