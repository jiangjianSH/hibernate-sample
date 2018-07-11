package com.jiangjian.learning.hibernate.columntransformer;

import com.jiangjian.learning.hibernate.SessionUtil;

public class Main {
    public static void main(String[] args) {
        Savings savings = new Savings();
        savings.setId(1L);
        MonetaryAmount monetaryAmount = new MonetaryAmount(1000L, "RMB");
        savings.setWallet(monetaryAmount);
        SessionUtil.persist(savings);
    }
}
