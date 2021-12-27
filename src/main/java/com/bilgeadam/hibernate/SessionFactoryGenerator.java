package com.bilgeadam.hibernate;

import com.bilgeadam.hibernate.entity.Customer;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

public class SessionFactoryGenerator {

    public SessionFactory acquireSession(){
        Configuration config = new Configuration();
        Properties prop = new Properties();

        try {
            prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        config.setProperties(prop);
        config.addAnnotatedClass(Customer.class);

        return config.buildSessionFactory();
    }
}
