package com.hibernate;

import com.hibernate.entity.*;
import com.hibernate.util.HibernateUtils;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

@Slf4j
public class ManyToManyApp {
    public static void main(String[] args) {
        Session session = HibernateUtils.getSessionFactory().openSession();

        try {
            org.hibernate.Transaction transaction = session.beginTransaction();

            Account account = createNewAccount();
            Account account2 = createNewAccount();
            User user = createUser();
            User user2 = createUser();

            account.getUsers().add(user);
            account.getUsers().add(user2);

            user.getAccounts().add(account);
            user.getAccounts().add(account2);

            account2.getUsers().add(user);
            account2.getUsers().add(user2);

            user2.getAccounts().add(account);
            user2.getAccounts().add(account2);

            session.save(account);
            session.save(account2);

            transaction.commit();

            Account getAccount = session.get(Account.class, account.getId());

            log.info(getAccount.getUsers().iterator().next().getEmailAddress());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtils.getSessionFactory().close();
        }
    }

    private static User createUser() {
        User user = new User();
        Address address = createAddress();
        user.setAddress(Arrays.asList(new Address[]{createAddress()}));
        user.setBirthDate(new Date());
        user.setCreatedBy("Kevin Bowersox");
        user.setCreatedDate(new Date());
        user.setCredential(createCredential(user));
        user.setEmailAddress("test@test.com");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setLastUpdatedBy("system");
        user.setLastUpdatedDate(new Date());
        return user;
    }

    private static Credential createCredential(User user) {
        Credential credential = new Credential();
        credential.setUser(user);
        credential.setUsername("test_username");
        credential.setPassword("test_password");
        return credential;
    }

    private static Address createAddress() {
        Address address = new Address();
        address.setAddressLine1("101 Address Line");
        address.setAddressLine2("102 Address Line");
        address.setCity("New York");
        address.setState("PA");
        address.setZipCode("10000");
        address.setAddressType("PRIMARY");
        return address;
    }

    private static Transaction createNewBeltPurchase(Account account) {
        Transaction beltPurchase = new Transaction();
        beltPurchase.setAccount(account);
        beltPurchase.setTitle("Dress Belt");
        beltPurchase.setAmount(new BigDecimal("50.00"));
        beltPurchase.setClosingBalance(new BigDecimal("0.00"));
        beltPurchase.setCreatedBy("Kevin Bowersox");
        beltPurchase.setCreatedDate(new Date());
        beltPurchase.setInitialBalance(new BigDecimal("0.00"));
        beltPurchase.setLastUpdatedBy("Kevin Bowersox");
        beltPurchase.setLastUpdatedDate(new Date());
        beltPurchase.setNotes("New Dress Belt");
        beltPurchase.setTransactionType("Debit");
        return beltPurchase;
    }

    private static Transaction createShoePurchase(Account account) {
        Transaction shoePurchase = new Transaction();
        shoePurchase.setAccount(account);
        shoePurchase.setTitle("Work Shoes");
        shoePurchase.setAmount(new BigDecimal("100.00"));
        shoePurchase.setClosingBalance(new BigDecimal("0.00"));
        shoePurchase.setCreatedBy("Kevin Bowersox");
        shoePurchase.setCreatedDate(new Date());
        shoePurchase.setInitialBalance(new BigDecimal("0.00"));
        shoePurchase.setLastUpdatedBy("Kevin Bowersox");
        shoePurchase.setLastUpdatedDate(new Date());
        shoePurchase.setNotes("Nice Pair of Shoes");
        shoePurchase.setTransactionType("Debit");
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
