package com.hibernate.hibernateApps;

import com.hibernate.entity.Account;
import com.hibernate.entity.Transaction;
import com.hibernate.util.HibernateUtils;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.util.Date;

public class OneToMany {

    public static void main(String[] args) {
        Session session = HibernateUtils.getSessionFactory().openSession();

        try {
            org.hibernate.Transaction transaction = session.beginTransaction();

            Account account = createNewAccount();
            account.getTransactions().add(createNewBeltPurchase());
            account.getTransactions().add(createShoePurchase());
            session.save(account);

            transaction.commit();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtils.getSessionFactory().close();
        }

    }

    private static Transaction createNewBeltPurchase() {
        Transaction beltPurchase = new Transaction();
        beltPurchase.setTitle("Dress Belt");
        beltPurchase.setAmount(new BigDecimal("50.00"));
        beltPurchase.setClosingBalance(new BigDecimal("0.00"));
        beltPurchase.setCreatedBy("Rhye");
        beltPurchase.setCreatedDate(new Date());
        beltPurchase.setInitialBalance(new BigDecimal("0.00"));
        beltPurchase.setLastUpdatedBy("Rhye");
        beltPurchase.setLastUpdatedDate(new Date());
        beltPurchase.setTransactionType("DEBIT");

        return beltPurchase;
    }

    private static Transaction createShoePurchase() {
        Transaction shoePurchase = new Transaction();
        shoePurchase.setTitle("Work Shoes");
        shoePurchase.setAmount(new BigDecimal("100.00"));
        shoePurchase.setClosingBalance(new BigDecimal("0.00"));
        shoePurchase.setCreatedBy("Rhye");
        shoePurchase.setCreatedDate(new Date());
        shoePurchase.setInitialBalance(new BigDecimal("0.00"));
        shoePurchase.setLastUpdatedBy("Rhye");
        shoePurchase.setLastUpdatedDate(new Date());
        shoePurchase.setTransactionType("DEBIT");

        return shoePurchase;
    }

    private static Account createNewAccount() {
        Account account = new Account();
        account.setCloseDate(new Date());
        account.setOpenDate(new Date());
        account.setCreatedBy("Kevin Bowersox");
        account.setInitialBalance(new BigDecimal("50.00"));
        account.setName("Savings Account");
        account.setCurrentBalance(new BigDecimal("100.00"));
        account.setLastUpdatedBy("Kevin Bowersox");
        account.setLastUpdatedDate(new Date());
        account.setCreatedDate(new Date());
        return account;
    }
}
