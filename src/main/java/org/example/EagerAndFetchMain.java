package org.example;

import org.example.entities.Account;
import org.example.entities.Client;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class EagerAndFetchMain {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session1 = sessionFactory.openSession();
        Transaction transaction = session1.beginTransaction();

        Client client1 = new Client("Darlene Todd");
        Client client2 = new Client("Henry Saunders");

        Account account1 = new Account(1000, client1);
        Account account2 = new Account(2000, client2);
        Account account3 = new Account(5000, client2);

        session1.persist(account1);
        session1.persist(account2);
        session1.persist(account3);
        transaction.commit();


        Session session2 = sessionFactory.openSession();

        Transaction transaction2 = session2.beginTransaction();
        Client client = session2.get(Client.class, 2L);

        System.out.println(client);

        List<Account> accounts = client.getAccounts();
        System.out.println(accounts);

        transaction2.commit();
    }
}
