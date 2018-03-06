package com.hibernate;

import com.hibernate.entity.Credential;
import com.hibernate.entity.User;
import com.hibernate.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class OneToOneApp {

    public static void main(String[] args) {
        Session session = HibernateUtils.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();

            User user = new User();
            user.setAge(22);
            user.setBirthDate(new Date());
            user.setCreatedDate(new Date());
            user.setCreatedBy("Kevin");
            user.setEmailAddress("kmb3");
            user.setFirstName("kevin");
            user.setLastName("bowersox");
            user.setLastUpdatedBy("kevin");
            user.setLastUpdatedDate(new Date());

            Credential credential = new Credential();
            credential.setPassword("kevinpassword");
            credential.setUsername("kmb123");
            credential.setUser(user);
            user.setCredential(credential);

            session.save(credential);

            transaction.commit();

            User dbUser = session.get(User.class, credential.getUser().getUserId());
            System.out.println(dbUser.getFirstName());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtils.getSessionFactory().close();
        }
    }
}
