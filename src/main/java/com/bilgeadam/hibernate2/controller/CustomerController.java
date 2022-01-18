package com.bilgeadam.hibernate2.controller;

import com.bilgeadam.hibernate2.SessionGenerator;
import com.bilgeadam.hibernate2.entities.customers.Address;
import com.bilgeadam.hibernate2.entities.customers.Customer;
import com.bilgeadam.hibernate2.entities.customers.State;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Optional;

public class CustomerController {

    private final SessionFactory factory;

    public CustomerController() {
        this.factory = SessionGenerator.generateSession();
    }

    public boolean addCustomer(Customer customer) {

        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();

            session.save(customer);

            transaction.commit();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteCustomer(long id) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            Customer customer = session.get(Customer.class, id);

            if (customer == null) {
                return false;
            } else {
                Query query = session.createQuery("UPDATE Customer SET accountState =:state WHERE ID=:id");
                query.setParameter("state", State.INACTIVE);
                query.setParameter("id", id);
                int i = query.executeUpdate();

//                customer.setAccountState(State.INACTIVE);
//                session.saveOrUpdate(customer);

                transaction.commit();
                return i == 1;
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    public boolean updateCustomerAddress(long id, Address address) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();

            Customer customer = session.get(Customer.class, id);
            if (customer == null || customer.getAccountState() == State.INACTIVE) {
                return false;
            } else {
                customer.setAddress(address);
                session.saveOrUpdate(address);
                session.saveOrUpdate(customer);
                transaction.commit();
                return true;
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    public Optional<Customer> getCustomer(long ID, boolean includeInactive, boolean includeAddress) {
        Optional<Customer> customer = Optional.empty();

        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Customer response = session.get(Customer.class, ID);
            if (includeAddress) {
                Hibernate.initialize(response.getAddress());
            }

            transaction.commit();

            if (response != null && (includeInactive || response.getAccountState() != State.INACTIVE)) {
                customer = Optional.of(response);
            }
        }
        return customer;
    }

    public boolean hardDeleteCustomer(long id) {

        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
            session.delete(customer);

            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
