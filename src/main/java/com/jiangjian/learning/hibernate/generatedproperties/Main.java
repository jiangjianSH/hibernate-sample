package com.jiangjian.learning.hibernate.generatedproperties;

import com.jiangjian.learning.hibernate.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        Person person = new Person();
//        person.setId( new Random().nextLong());
//        person.setFirstName( "John" );
//        person.setMiddleName1( "Flávio" );
//        person.setMiddleName2( "André" );
//        person.setMiddleName3( "Frederico" );
//        person.setMiddleName4( "Rúben" );
//        person.setMiddleName5( "Artur" );
//        person.setLastName( "Doe" );
//
//        SessionUtil.persist(person);


        EntityManager entityManager = SessionUtil.sessionFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Person person1 = entityManager.find(Person.class, 7471725946943459473L);
        person1.setFirstName("222ss");
        person1.setPassword("fff");
        entityManager.persist(person1);
        transaction.commit();
        entityManager.close();
        SessionUtil.sessionFactory.close();
    }
}
