package com.jiangjian.learning.hibernate.annotations.formula;

import org.hibernate.annotations.Formula;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Account")
public class Account {

    @Id
    private Long id;

    private Double credit;

    private Double rate;

    @Formula(value = "credit * rate")
    private Double interest;

    //Getters and setters omitted for brevity


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    @Override
    public String toString() {
        return "ClientAccount{" +
                "id=" + id +
                ", credit=" + credit +
                ", rate=" + rate +
                ", interest=" + interest +
                '}';
    }
}