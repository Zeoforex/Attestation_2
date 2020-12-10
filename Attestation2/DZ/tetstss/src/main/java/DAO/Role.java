package Attestation2.Attestation2.DZ.tetstss.src.main.java.dao;

import models.Role;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Role implements Dao<Role> {

    private List<Role> roles = new ArrayList<>();

    public Role(){

    }

    public Role findById(int id){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Role role = session.get(Role.class, id);
        session.close();
        return role;
    }

    @Override
    public Optional<Role> get(int id) {
        return Optional.ofNullable(roles.get((int) id));
    }


    @Override
    public void save(Role role){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(role);
        tx1.commit();
        session.close();
    }


    @Override
    public void delete(Role role){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(role);
        tx1.commit();
        session.close();
    }



    @Override
    public void update(Role role) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(role);
        tx1.commit();
        session.close();
    }



    @Override
    public List<Role> getAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        return (List<Role>) session.createQuery("From Role").list();
    }




}