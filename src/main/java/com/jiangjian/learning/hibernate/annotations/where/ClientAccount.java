package com.jiangjian.learning.hibernate.annotations.where;

import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity(name = "Account")
@Table(name = "Client_Account")
@Where( clause = "active = true" )
public class ClientAccount {

    @Id
    private Long id;

    @ManyToOne
    private Client client;

    @Column(name = "account_type")
    @Enumerated(EnumType.STRING)
    private ClientAccountType type;

    private Double amount;

    private Double rate;

    private boolean active;

    //Getters and setters omitted for brevity

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ClientAccountType getType() {
        return type;
    }

    public void setType(ClientAccountType type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "ClientAccount{" +
                "id=" + id +
                ", client=" + client +
                ", type=" + type +
                ", amount=" + amount +
                ", rate=" + rate +
                ", active=" + active +
                '}';
    }
}