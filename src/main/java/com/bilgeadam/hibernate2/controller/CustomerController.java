package com.bilgeadam.hibernate2.controller;

import com.bilgeadam.hibernate2.SessionGenerator;
import com.bilgeadam.hibernate2.entities.Address;
import com.bilgeadam.hibernate2.entities.Customer;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CustomerController {

    private SessionFactory factory;

    public CustomerController(){
        this.factory = SessionGenerator.generateSession();
    }

    public boolean addCustomer (Customer customer) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();

            session.saveOrUpdate(customer);

            transaction.commit();
            return true;

        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            return false;
        }
    }

    public boolean deleteCustomer (long id) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            Customer customer = session.get(Customer.class, id);

            if (customer == null) {
                return false;
            } else {
                session.delete(customer);
                transaction.commit();
                return true;
            }
        } catch (Exception e) {
            if (transaction != null){
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
            if (customer == null) {
                return false;
            } else {
                customer.setAddress(address);
                session.saveOrUpdate(address);
                session.saveOrUpdate(customer);
                transaction.commit();
                return true;
            }
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            return false;
        }
    }

    public boolean addCustomerToy(long customerId, long toyId){
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
//            Customer customer = session.get(Customer.class, id);
//            if (customer == null) {
//                return false;
//            }
//            customer.addToy(toy);
//            session.saveOrUpdate(customer);
//            transaction.commit();

            Query query = session.createQuery("INSERT INTO customer_toys(customer_id, toy_id) VALUES(:cId :tId)");
            query.setParameter("cId", customerId);
            query.setParameter("tId", toyId);
            query.executeUpdate();
            transaction.commit();

            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
