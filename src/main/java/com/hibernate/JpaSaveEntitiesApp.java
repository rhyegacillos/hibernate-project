package com.hibernate;

import com.hibernate.entity.Bank;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class JpaSaveEntitiesApp {

    public static void main(String[] args) {
        EntityManagerFactory factory = null;
        EntityManager em = null;

        EntityTransaction tx = null;

        try {
            factory = Persistence.createEntityManagerFactory("infinite-finances");
            em = factory.createEntityManager();
            tx = em.getTransaction();
            tx.begin();

            Bank bank = createBank();
            em.persist(bank);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
            factory.close();
        }


    }


    private static Bank createBank() {
        Bank bank = new Bank();
        bank.setName("Federal Trusty");
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

        bank.getContacts().put("Manager", "Joe");
        bank.getContacts().put("Teller", "Mary");

        return bank;
    }
}
