package com.hibernate;

import com.hibernate.entity.Bank;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class JpaModifyEntitiesApp {

    public static void main(String[] args) {
        EntityManagerFactory factory = null;
        EntityManager em = null;

        EntityTransaction tx = null;

        try {
            factory = Persistence.createEntityManagerFactory("infinite-finances");
            em = factory.createEntityManager();
            tx = em.getTransaction();
            tx.begin();

            Bank bank = em.find(Bank.class, 9L);

            bank.setName("New Bank Name");

            em.persist(bank);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
            factory.close();
        }


    }
}
