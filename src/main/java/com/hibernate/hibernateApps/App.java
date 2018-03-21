package com.hibernate.hibernateApps;

import com.hibernate.entity.User;
import com.hibernate.util.HibernateUtils;
import org.hibernate.Session;

import java.util.Calendar;
import java.util.Date;


public class App {
    public static void main(String[] args) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();

            User user = new User();
            user.setBirthDate(getMyBirthday());
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

            session.refresh(user);

            System.out.println(user.getAge());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtils.getSessionFactory().close();
        }
    }

    private static Date getMyBirthday() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 1986);
        calendar.set(Calendar.MONTH, 10);
        calendar.set(Calendar.DATE, 29);

        return calendar.getTime();
    }
}
