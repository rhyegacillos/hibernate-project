package com.hibernate;

import com.hibernate.entity.AccountType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.Properties;


public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(AccountType.class);

        configuration.setProperties(new Properties() {
            {
                put("hibernate.connection.username", "infinite");
                put("hibernate.connection.password", "skills");
                put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
                put("hibernate.connection.url", "jdbc:mysql://localhost:3306/ifinances");
            }
        });

        // Building SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory(
                new StandardServiceRegistryBuilder().applySettings(
                        configuration.getProperties()).build());

        // Obtain Session and Call Persistence Methods
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        AccountType accountType = new AccountType();

        accountType.setName("Checking");
        accountType.setCreatedDate(new Date());
        accountType.setLastUpdatedDate(new Date());
        accountType.setCreatedBy("rhye");
        accountType.setLastUpdatedBy("rhye");

        session.save(accountType);
        session.getTransaction().commit();
        session.close();


    }
}
