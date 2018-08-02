package com.example.demo.dao;

import com.example.demo.entities.Person;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prashant Kumar on 1/8/18
 */
@Service
public class SimpleDao {

    Configuration configuration = new Configuration().configure();
    SessionFactory sessionFactory = configuration.buildSessionFactory();

    public SimpleDao() {
    }

    public List<Person> getPersons(){

        Session session = sessionFactory.openSession();

        Query query = session.createQuery("FROM person");

        List<Person> people = new ArrayList<>();
        try {
            people = query.list();
            session.close();
        }catch (Exception e){}

        return people;
    }

    public boolean addPerson(Person person){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(person);
            transaction.commit();

            session.close();
            return true;

        }catch (Exception e){
            return false;
        }

    }
}
