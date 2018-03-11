package com.hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity(name = "ACCOUNT")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCOUNT_ID")
    private Long id;

//    @Column(Bank)
//    private int bankId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    List<Transaction> transactions = new ArrayList<>();

    @Column(name = "NAME")
    private String name;

    @Column(name = "INITIAL_BALANCE")
    private BigDecimal initialBalance;

    @Column(name = "CURRENT_BALANCE")
    private BigDecimal currentBalance;

    @Column(name = "OPEN_DATE")
    private Date openDate;

    @Column(name = "CLOSE_DATE")
    private Date closeDate;

    @Column(name = "LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_UPDATED_DATE")
    private Date lastUpdatedDate;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_DATE")
    private Date createdDate;
}
