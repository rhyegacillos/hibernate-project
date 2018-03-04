package com.hibernate.util;

import com.hibernate.entity.AccountType;
import com.hibernate.entity.Bank;
import com.hibernate.entity.TimeTest;
import com.hibernate.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(TimeTest.class);
            configuration.addAnnotatedClass(AccountType.class);
            configuration.addAnnotatedClass(Bank.class);
            return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().build());
        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException("There was an error building the factory");
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }


}
