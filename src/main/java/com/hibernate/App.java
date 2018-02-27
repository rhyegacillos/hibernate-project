package com.hibernate;

import com.hibernate.entity.User;
import com.hibernate.util.HibernateUtils;
import org.hibernate.Session;

import java.util.Date;


public class App 
{
    public static void main( String[] args )
    {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.getTransaction().begin();

        User user = new User();
        user.setBirthDate(new Date());
        user.setCreatedBy("Rhye");
        user.setFirstName("Rhye");
        user.setLastName("Gacillos");
        user.setLastUpdatedDate(new Date());
        user.setLastUpdatedBy("Rhye");
        user.setEmailAddress("gacillos.rhye@gmail.com");
        user.setCreatedBy("Rhye");
        user.setCreatedDate(new Date());

        session.save(user);
        session.getTransaction().commit();

        session.beginTransaction();
        User updateUser = session.get(User.class, user.getUserId());
        updateUser.setFirstName("Rahye");
        session.update(updateUser);
        session.getTransaction().commit();
        session.close();
    }
}
