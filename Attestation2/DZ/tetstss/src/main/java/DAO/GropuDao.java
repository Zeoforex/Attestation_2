package DAO;

import models.Group;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GroupDao implements Dao<Group>{

    private List<Group> groups = new ArrayList<>();

    public GroupDao(){

    }

    public Group findById(int id){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Group group = session.get(Group.class, id);
        session.close();
        return group;
    }

    @Override
    public Optional<Group> get(int id) {
        return Optional.ofNullable(groups.get((int) id));
    }

    @Override
    public List<Group> getAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        return (List<Group>) session.createQuery("From Group").list();
    }

    @Override
    public void save(Group group){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(group);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Group group) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(group);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Group group){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(group);
        tx1.commit();
        session.close();
    }


}
