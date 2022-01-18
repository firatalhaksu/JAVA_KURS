package com.bilgeadam.hibernate.controller;

import com.bilgeadam.hibernate.SessionGenerator;
import com.bilgeadam.hibernate.entities.customers.Customer;
import com.bilgeadam.hibernate.entities.orders.Order;
import com.bilgeadam.hibernate.entities.toys.Toy;
import org.hibernate.*;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OrderController {
    private final SessionFactory factory;
    private final CustomerController customerController;

    public OrderController(){
        this.customerController = new CustomerController();
        this.factory = SessionGenerator.generateSession();
    }


    public boolean addOrder(long customerId, Map<Toy, Long> orders){
        try(Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Customer customer = session.get(Customer.class, customerId);
            Order order = new Order(customer, orders);

            session.saveOrUpdate(order);
            transaction.commit();
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public List<Order> getOrders(Customer customer) {
        List<Order> response = new ArrayList<>();
        try(Session session = factory.openSession()){
            Transaction transaction = session.beginTransaction();
            Query<?> query = session.createQuery("SELECT orderDetails FROM Order WHERE customer.id =: cId");
            response = (List<Order>) query.getResultList();

            transaction.commit();
            return response;

        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public boolean addOrder(Customer customer, Map<Toy, Long> orders){
        try(Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            customer = session.get(Customer.class, customer.getID());
            Order order = new Order(customer, orders);

            session.saveOrUpdate(order);
            transaction.commit();
            return true;
        } catch (Exception e){
            return false;
        }
    }

    void deleteOrders(){
        try(Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Query<?> query = session.createQuery("DELETE Order");
            query.executeUpdate();
            transaction.commit();
        }
    }
}
