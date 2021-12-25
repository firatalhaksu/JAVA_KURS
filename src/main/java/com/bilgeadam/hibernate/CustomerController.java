package com.bilgeadam.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CustomerController {
    private final SessionFactory sessionFactory;

    public CustomerController() {
        this.sessionFactory = new SessionFactoryGenerator().acquireSession();
    }

    public void addCustomer(Customer customer){
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction;

            transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
        }
    }
}
