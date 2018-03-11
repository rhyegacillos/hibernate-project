package com.hibernate.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(exclude="credential")
@Entity(name = "FINANCES_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long userId;

    @ManyToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Account> accounts = new ArrayList<>();

    @OneToOne(mappedBy = "user")
    private Credential credential;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "BIRTH_DATE", nullable = false)
    private Date birthDate;

    @Column(name = "LAST_UPDATED_DATE")
    private Date lastUpdatedDate;

    @Column(name = "LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @Column(name = "CREATED_DATE", updatable = false)
    private Date createdDate;

    @Column(name = "CREATED_BY", updatable = false)
    private String createdBy;

    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    @Formula("lower(datediff(curdate(), birth_date)/365)")
    private int age;

    @ElementCollection
    @CollectionTable(name = "USER_ADDRESS", joinColumns = @JoinColumn(name = "USER_ID"))
    @AttributeOverrides({@AttributeOverride(name = "addressLine1", column = @Column(name = "USER_ADDRESS_LINE_1")),
            @AttributeOverride(name = "addressLine2", column = @Column(name = "USER_ADDRESS_LINE_2"))})
    private List<Address> address = new ArrayList<>();
}
