package com.hibernate;

import com.hibernate.entity.Address;
import com.hibernate.entity.Bank;
import com.hibernate.entity.User;
import com.hibernate.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class UserApp {

    public static void main(String[] args) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();

            User user = new User();
            Address address = new Address();

            user.setAge(22);
            user.setBirthDate(new Date());
            user.setCreatedDate(new Date());
            user.setCreatedBy("Kevin");
            user.setEmailAddress("kmb3");
            user.setFirstName("kevin");
            user.setLastName("bowersox");
            user.setLastUpdatedBy("kevin");
            user.setLastUpdatedDate(new Date());

            address.setAddressLine1("line 1");
            address.setAddressLine2("line 2");
            address.setCity("Philadelphia");
            address.setState("PA");
            address.setZipCode("12345");

            user.setAddress(address);
            session.save(user);

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtils.getSessionFactory().close();
        }
    }
}
