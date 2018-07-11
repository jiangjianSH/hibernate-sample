package com.jiangjian.learning.hibernate.annotations.where;

import com.jiangjian.learning.hibernate.SessionUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Client client = new Client();
        client.setId( 1L );
        client.setName( "John Doe" );

        ClientAccount ClientAccount1 = new ClientAccount( );
        ClientAccount1.setId( 1L );
        ClientAccount1.setType( ClientAccountType.CREDIT );
        ClientAccount1.setAmount( 5000d );
        ClientAccount1.setRate( 1.25 / 100 );
        ClientAccount1.setActive( true );
        ClientAccount1.setClient( client );
        client.getCreditClientAccounts().add( ClientAccount1 );

        ClientAccount ClientAccount2 = new ClientAccount( );
        ClientAccount2.setId( 2L );
        ClientAccount2.setType( ClientAccountType.DEBIT );
        ClientAccount2.setAmount( 0d );
        ClientAccount2.setRate( 1.05 / 100 );
        ClientAccount2.setActive( false );
        ClientAccount2.setClient( client );
        client.getDebitClientAccounts().add( ClientAccount2 );

        ClientAccount ClientAccount3 = new ClientAccount( );
        ClientAccount3.setType( ClientAccountType.DEBIT );
        ClientAccount3.setId( 3L );
        ClientAccount3.setAmount( 250d );
        ClientAccount3.setRate( 1.05 / 100 );
        ClientAccount3.setActive( true );
        ClientAccount3.setClient( client );
        client.getDebitClientAccounts().add( ClientAccount3 );

        EntityManager entityManager = SessionUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist( client );


        List<ClientAccount> accounts = entityManager.createQuery(
                "select a from Account a", ClientAccount.class)
                .getResultList();
        System.out.println(accounts.size());
        transaction.commit();
        entityManager.close();
        SessionUtil.sessionFactory.close();
    }
}
