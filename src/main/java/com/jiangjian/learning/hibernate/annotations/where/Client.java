package com.jiangjian.learning.hibernate.annotations.where;

import org.hibernate.annotations.Where;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Client")
public class Client {
    @Id
    private Long id;

    private String name;

    @Where( clause = "account_type = 'DEBIT'")
    @OneToMany(mappedBy = "client", cascade= CascadeType.PERSIST)
    private List<ClientAccount> debitClientAccounts = new ArrayList<>( );

    @Where( clause = "account_type = 'CREDIT'")
    @OneToMany(mappedBy = "client", cascade= CascadeType.PERSIST)
    private List<ClientAccount> creditClientAccounts = new ArrayList<>( );

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ClientAccount> getDebitClientAccounts() {
        return debitClientAccounts;
    }

    public void setDebitClientAccounts(List<ClientAccount> debitClientAccounts) {
        this.debitClientAccounts = debitClientAccounts;
    }

    public List<ClientAccount> getCreditClientAccounts() {
        return creditClientAccounts;
    }

    public void setCreditClientAccounts(List<ClientAccount> creditClientAccounts) {
        this.creditClientAccounts = creditClientAccounts;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", debitClientAccounts=" + debitClientAccounts +
                ", creditClientAccounts=" + creditClientAccounts +
                '}';
    }
}