package DAO;

import models.Answer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AnswerDao implements Dao<Answer> {

    private List<Answer> answers = new ArrayList<>();

    public AnswerDao() {

    }

    public Answer findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Answer answer = session.get(Answer.class, id);
        session.close();
        return answer;
    }

    @Override
    public Optional<Answer> get(int id) {
        return Optional.ofNullable(answers.get((int) id));
    }

    @Override
    public List<Answer> getAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        return (List<Answer>) session.createQuery("From Answer").list();
    }

    @Override
    public void save(Answer answer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(answer);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Answer answer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(answer);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Answer answer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(answer);
        tx1.commit();
        session.close();
    }

}