package com.jiangjian.learning.hibernate.columntransformer;

import javax.persistence.Column;

public class MonetaryAmount {
    @Column(name = "money")
    private long money;
    @Column(name = "currency")
    private String currency;

    public MonetaryAmount() {
    }

    public MonetaryAmount(long money, String currency) {
        this.money = money;
        this.currency = currency;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
