package com.bilgeadam.hibernate2.controller;

import com.bilgeadam.hibernate2.SessionGenerator;
import com.bilgeadam.hibernate2.entities.toys.ToyType;
import com.bilgeadam.hibernate2.entities.toys.Toy;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ToyController {

    private final SessionFactory factory;

    public ToyController(){
        this.factory = SessionGenerator.generateSession();
    }

    public boolean addNewToy (Toy toy) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();

            session.saveOrUpdate(toy);

            transaction.commit();
            return true;

        } catch (Exception e) {
            if (transaction != null){
                try{
                    transaction.rollback();
                } catch (Exception ex){

                }
            }
            return false;
        }
    }

    public boolean deleteToy (long id) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            Toy toy = session.get(Toy.class, id);

            if (toy == null) {
                return false;
            } else {
                session.delete(toy);
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

    public boolean updateToyType(long id, ToyType newType) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();

            Query query = session.createQuery("UPDATE Toy t SET t.type=:type WHERE t.ID =:id");
            query.setParameter("type", newType);
            query.setParameter("id", id);

            int i = query.executeUpdate();
            transaction.commit();

            return i == 1;

/*            Toy toy = session.get(Toy.class, id);
            if (toy == null) {
                return false;
            } else {
                toy.setType(newType);

                session.saveOrUpdate(toy);
                transaction.commit();
                return true;
            }*/
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            return false;
        }
    }
}
