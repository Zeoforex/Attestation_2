package Attestation2.Attestation2.DZ.tetstss.src.main.java.dao;

import models.Subject;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Subject implements Dao<Subject> {

    private List<Subject> subjects = new ArrayList<>();

    public Subject(){

    }

    public Subject findById(int id){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Subject subject = session.get(Subject.class, id);
        session.close();
        return subject;
    }

    @Override
    public Optional<Subject> get(int id) {
        return Optional.ofNullable(subjects.get((int) id));
    }

    @Override
    public List<Subject> getAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        return (List<Subject>) session.createQuery("From Subject").list();
    }

    @Override
    public void save(Subject subject){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(subject);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Subject subject) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(subject);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Subject subject){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(subject);
        tx1.commit();
        session.close();
    }


}
