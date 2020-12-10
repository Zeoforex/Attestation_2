package Attestation2.Attestation2.DZ.tetstss.src.main.java.dao;

import models.Schedule;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Schedule implements Dao<Schedule> {

    private List<Schedule> schedules = new ArrayList<>();

    public Schedule(){

    }

    public Schedule findById(int id){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Schedule schedule = session.get(Schedule.class, id);
        session.close();
        return schedule;
    }

    @Override
    public Optional<Schedule> get(int id) {
        return Optional.ofNullable(schedules.get((int) id));
    }

    @Override
    public List<Schedule> getAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        return (List<Schedule>) session.createQuery("From Schedule").list();
    }

    @Override
    public void save(Schedule schedule){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(schedule);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Schedule schedule) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(schedule);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Schedule schedule){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(schedule);
        tx1.commit();
        session.close();
    }

}

