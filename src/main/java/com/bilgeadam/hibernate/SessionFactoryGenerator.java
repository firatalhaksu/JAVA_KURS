package com.bilgeadam.hibernate;

import com.bilgeadam.hibernate.entity.Address;
import com.bilgeadam.hibernate.entity.Customer;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.io.IOException;
import java.util.Properties;

public class SessionFactoryGenerator {

    private SessionFactoryGenerator(){}

    public static SessionFactory acquireSessionFactory(String where){
        Configuration config = new Configuration();
        Properties prop = new Properties();

        return switch (where){
            case "XML" -> acquireSessionFactoryFromXML (config,prop);
            case "PROP" -> acquireSessionFactoryFromProperties (config,prop);
            case "CODE" -> acquireSessionFactoryFromCode (config,prop);
            default -> null;
        };
    }

    private static SessionFactory acquireSessionFactoryFromCode (Configuration config, Properties prop){
        prop.setProperty("hibernate.connection.url","jdbc:postgresql://localhost:5432/bilgeadam");
        prop.setProperty("hibernate.connection.username","jdbc");
        prop.setProperty("hibernate.connection.password",".");
        prop.setProperty("hibernate.hbm2ddl.auto","create");
        prop.setProperty("hibernate.show_sql","true");
        config.setProperties(prop);
        config.addAnnotatedClass(Customer.class);
        config.addAnnotatedClass(Address.class);
        return config.buildSessionFactory();
    }

    private static SessionFactory acquireSessionFactoryFromProperties (Configuration config, Properties prop){
        try {
            prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        config.setProperties(prop);
        config.addAnnotatedClass(Customer.class);
        config.addAnnotatedClass(Address.class);
        return config.buildSessionFactory();
    }

    private static SessionFactory acquireSessionFactoryFromXML (Configuration config, Properties prop){
        try {
            prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate.cfg.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        config.setProperties(prop);
        return config.buildSessionFactory();
    }
}