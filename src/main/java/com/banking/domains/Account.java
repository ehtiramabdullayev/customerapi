package com.banking.domains;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Master on 2/19/2018.
 */
@Entity
@Table(name = "accounts")
public class Account implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountNo;
    private Double balance;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    private Customer customer;
    @OneToMany(mappedBy = "account",cascade = CascadeType.REMOVE)
    private List<Statement> statements;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getaccountNo() {
        return accountNo;
    }

    public void setaccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public void setStatements(List<Statement> statements) {
        this.statements = statements;
    }

    public enum Status{
        ACTIVE,BLOCKED
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (id != null ? !id.equals(account.id) : account.id != null) return false;
        return accountNo != null ? accountNo.equals(account.accountNo) : account.accountNo == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (accountNo != null ? accountNo.hashCode() : 0);
        return result;
    }
}
