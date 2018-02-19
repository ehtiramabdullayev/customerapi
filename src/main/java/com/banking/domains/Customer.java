package com.banking.domains;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Master on 2/19/2018.
 */
@Entity
@Table(name = "customers")
public class Customer implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;
    private String password;
    @OneToMany(cascade = {CascadeType.REMOVE,CascadeType.PERSIST},mappedBy = "customer")
    private Set<Account> accounts;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }
}
