package com.hibernate;

import com.hibernate.entity.Bank;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

@Slf4j
public class JpaRetrieveEntitiesApp {

    public static void main(String[] args) {
        EntityManagerFactory factory = null;
        EntityManager em = null;

        EntityTransaction tx = null;

        factory = Persistence.createEntityManagerFactory("infinite-finances");
        em = factory.createEntityManager();
        tx = em.getTransaction();
        tx.begin();

        Bank bank = em.find(Bank.class, 9L);
        log.info("Exist: " + em.contains(bank));
        log.info("Bank name: " + bank.getName());

        em.persist(bank);

        tx.commit();

        em.close();
        factory.close();

    }


    private static Bank createBank() {
        Bank bank = new Bank();
        bank.setName("Federal Trust 1");
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
