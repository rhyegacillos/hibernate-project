package com.hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "BUDGET")
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BUDGET_ID")
    private Long budgetId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "GOAL_AMOUNT")
    private BigDecimal goalAmount;

    @Column(name = "PERIOD")
    private String period;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "BUDGET_TRANSACTION",
            joinColumns = @JoinColumn(name = "BUDGET_ID" ),
            inverseJoinColumns = @JoinColumn(name = "TRANSACTION_ID"))
    private List<Transaction> transactions = new ArrayList<>();
}
