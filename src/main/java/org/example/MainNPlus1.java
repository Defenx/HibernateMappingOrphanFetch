package org.example;

import org.example.entities.Account;
import org.example.entities.Client;
import org.example.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MainNPlus1 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session1 = sessionFactory.openSession();
        Transaction transaction = session1.beginTransaction();

        Client client1 = new Client("Darlene Todd");
        Client client2 = new Client("Henry Saunders");
        Client client3 = new Client("Kathleen Ballard");

        Account account1 = new Account(1000, client1);
        Account account2 = new Account(2000, client2);
        Account account3 = new Account(5000, client2);
        Account account4 = new Account(50000, client2);
        Account account5 = new Account(500000, client3);

        session1.persist(account1);
        session1.persist(account2);
        session1.persist(account3);
        session1.persist(account4);
        session1.persist(account5);
        transaction.commit();


        Session session2 = sessionFactory.openSession();

        Transaction transaction2 = session2.beginTransaction();

//        Query from_client = session2.createQuery("SELECT c FROM Client c");
        Query from_client = session2.createQuery("SELECT c FROM Client c JOIN FETCH c.accounts as acc");
        from_client.setFirstResult(1);
        from_client.setMaxResults(1);

        System.out.println(from_client.list());
        transaction2.commit();

    }
}
