package com.jiangjian.learning.hibernate.annotations.formula;

import com.jiangjian.learning.hibernate.SessionUtil;
import com.jiangjian.learning.hibernate.generatedproperties.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Main {
    public static void main(String[] args) {
//        ClientAccount account = new ClientAccount();
//        account.setId( 1L );
//        account.setCredit( 5000d );
//        account.setRate( 1.25 / 100 );
//        SessionUtil.persist(account);

       Account a = new SessionUtil<Account>().findById(Account.class, 1L);
        System.out.println(a);
    }
}
