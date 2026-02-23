package com.kce.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.kce.entity.Volunteer;
import com.kce.util.HibernateUtil;

public class VolunteerDAO {

    public boolean insertVolunteer(Volunteer v) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(v);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            return false;
        }
    }

    public Volunteer findVolunteer(String id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Volunteer.class, id);
        }
    }

    public boolean deleteVolunteer(String id) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Volunteer v = session.get(Volunteer.class, id);
            if (v != null) {
                session.remove(v);
                tx.commit();
                return true;
            }
        } catch (Exception e) {
            if (tx != null) tx.rollback();
        }
        return false;
    }
}
