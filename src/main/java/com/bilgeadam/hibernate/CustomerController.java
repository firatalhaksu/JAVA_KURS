package com.bilgeadam.hibernate;

import com.bilgeadam.hibernate.entity.Customer;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.Arrays;

public class CustomerController {
    private final SessionFactory sessionFactory;

    public CustomerController() {
        this.sessionFactory = SessionFactoryGenerator.acquireSessionFactory("PROP");
    }

    public void addCustomers(Customer... customer){
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Arrays.stream(customer).forEach(c -> {
                if (c.getAddress() != null){
                    session.saveOrUpdate(c.getAddress());
                    session.flush();
                }
                session.saveOrUpdate(c);
            });
            transaction.commit();
        }
    }

    public void deleteCustomer (int ID) {
        String HQL = "delete from Customer where ID = :id";

        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            Customer customer = session.get(Customer.class,ID);
            session.delete(customer);

            transaction.commit();
        }
    }

    public Customer getCustomer (int ID, boolean withEmails){
        Customer customer;
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            customer = session.get(Customer.class,ID);
            if (withEmails)
                Hibernate.initialize(customer.getEmails());
            transaction.commit();
        }
        return customer;
    }

    public void updateCustomer(int ID, String name){
        String HQL = "update Customer c set c.name = :name where c.ID= :id";
        try (Session session= sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            Query<?> query = session.createQuery(HQL).setParameter("name", name).setParameter("id", ID);

            query.executeUpdate();
            transaction.commit();
        }
    }
}