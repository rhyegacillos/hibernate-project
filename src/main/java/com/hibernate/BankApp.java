package com.hibernate;

import com.hibernate.entity.Bank;
import com.hibernate.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class BankApp {

    public static void main(String[] args) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();

            Bank bank = new Bank();
            bank.setName("Federal Trust");
            bank.getAddress().setAddressLine1("33 Wall Street");
            bank.getAddress().setAddressLine2("Suite 302");
            bank.getAddress().setCity("New York");
            bank.getAddress().setState("NY");
            bank.getAddress().setZipCode("27914");
            bank.setCreatedBy("Kevin Bowersox");
            bank.setCreatedDate(new Date());
            bank.setLastUpdatedBy("Kevin Bowersox");
            bank.setLastUpdatedDate(new Date());
            bank.setInternational(false);

            session.save(bank);

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtils.getSessionFactory().close();
        }
    }
}
