package Attestation2.Attestation2.DZ.tetstss.src.main.java.dao;

import models.Test;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Test implements Dao<Test> {

    private List<Test> tests = new ArrayList<>();

    public Test(){

    }

    public Test findById(int id){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Test test = session.get(Test.class, id);
        session.close();
        return test;
    }

    @Override
    public Optional<Test> get(int id) {
        return Optional.ofNullable(tests.get((int) id));
    }

    @Override
    public List<Test> getAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        return (List<Test>) session.createQuery("From Test").list();
    }

    @Override
    public void save(Test test){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(test);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Test test) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(test);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Test test){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(test);
        tx1.commit();
        session.close();
    }


}
