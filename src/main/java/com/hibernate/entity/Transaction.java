package com.hibernate.entity;


import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity(name = "TRANSACTION")
public class Transaction {

    @Id
    @Column(name = "TRANSACTION_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "TRANSACTION_TYPE")
    private String transactionType;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "INITIAL_BALANCE")
    private BigDecimal initialBalance;

    @Column(name = "CLOSING_BALANCE")
    private BigDecimal closingBalance;

    @Column(name = "NOTES")
    private String notes;

    @Column(name = "LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @Column(name = "LAST_UPDATED_DATE")
    private Date lastUpdatedDate;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATED_DATE")
    private Date createdDate;
}
