package com.bilgeadam.hibernate;

import com.bilgeadam.hibernate.entities.customers.Address;
import com.bilgeadam.hibernate.entities.customers.Customer;
import com.bilgeadam.hibernate.entities.orders.Order;
import com.bilgeadam.hibernate.entities.toys.Toy;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

public class SessionGenerator {

    private SessionGenerator(){}

    public static SessionFactory generateSession() {
        Configuration config = new org.hibernate.cfg.Configuration();
        Properties prop = new Properties();

        try {
            prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        config.setProperties(prop);
        config.addAnnotatedClass(Toy.class);
        config.addAnnotatedClass(Address.class);
        config.addAnnotatedClass(Customer.class);
        config.addAnnotatedClass(Order.class);

        return config.buildSessionFactory();
    }
}