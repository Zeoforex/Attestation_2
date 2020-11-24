package DAO;

import models.Question;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QuestionDao implements Dao<Question> {

    private List<Question> questions = new ArrayList<>();

    public QuestionDao(){

    }

    public Question findById(int id){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Question question = session.get(Question.class, id);
        session.close();
        return question;
    }

    @Override
    public Optional<Question> get(int id) {
        return Optional.ofNullable(questions.get((int) id));
    }

    @Override
    public List<Question> getAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        return (List<Question>) session.createQuery("From Question").list();
    }

    @Override
    public void save(Question question){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(question);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Question question) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(question);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Question question){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(question);
        tx1.commit();
        session.close();
    }

}