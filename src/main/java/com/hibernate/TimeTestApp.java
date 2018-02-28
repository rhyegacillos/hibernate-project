package com.hibernate;

import com.hibernate.entity.TimeTest;
import com.hibernate.util.HibernateUtils;
import org.hibernate.Session;

import java.util.Date;

public class TimeTestApp {

    public static void main(String[] args) {

        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.getTransaction().begin();

            TimeTest test = new TimeTest(new Date());
            session.save(test);
            session.getTransaction().commit();

            session.refresh(test);

            System.out.println(test.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtils.getSessionFactory().close();
        }
    }
}
