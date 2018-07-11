package com.jiangjian.learning.hibernate;

import com.jiangjian.learning.hibernate.annotations.formula.Account;
import com.jiangjian.learning.hibernate.annotations.where.Client;
import com.jiangjian.learning.hibernate.annotations.where.ClientAccount;
import com.jiangjian.learning.hibernate.columntransformer.Savings;
import com.jiangjian.learning.hibernate.customebasictype.BitSetType;
import com.jiangjian.learning.hibernate.customebasictype.Product;
import com.jiangjian.learning.hibernate.generatedproperties.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Properties;

public class SessionUtil<T> {
    public static SessionFactory sessionFactory;


   static {
        Properties properties = new Properties();
        properties.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&autoReconnect=true&failOverReadOnly=false&autoReconnectForPools=true&serverTimezone=GMT");
        properties.setProperty("hibernate.connection.username", "root");
        properties.setProperty("hibernate.connection.password", "root");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.format_sql", "true");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.globally_quoted_identifiers", "true");
        Configuration configuration = new Configuration()
                .registerTypeContributor(((typeContributions, serviceRegistry)
                    -> typeContributions.contributeType(BitSetType.INSTANCE)))
                .setProperties(properties)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Savings.class)
                .addAnnotatedClass(Account.class)
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(ClientAccount.class);

        sessionFactory = configuration.buildSessionFactory();

    }

    public static Object persist(Object t) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.persist( t );
        transaction.commit();
        session.close();
        return t;
    }

    public static Object update(Object t) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.update( t );
        transaction.commit();
        session.close();
        return t;
    }


    public T findById(Class<T> t, Long id) {
        EntityManager entityManager = SessionUtil.sessionFactory.createEntityManager();
        return entityManager.find(t, id);
    }

    public static EntityManager getEntityManager() {
        return SessionUtil.sessionFactory.createEntityManager();
    }

}
