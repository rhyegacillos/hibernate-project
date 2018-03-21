package com.hibernate;

import com.hibernate.entity.Bank;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class JpaConfigApp {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("infinite-finances");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Bank bank = createBank();

        em.persist(bank);

        tx.commit();

        em.close();
        emf.close();
    }


    private static Bank createBank() {
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

        bank.getContacts().put("Manager", "Joe");
        bank.getContacts().put("Teller", "Mary");

        return bank;
    }
}
