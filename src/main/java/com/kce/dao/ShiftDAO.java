package com.kce.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.kce.entity.Shift;
import com.kce.util.HibernateUtil;

public class ShiftDAO {

    public boolean insertShift(Shift s) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(s);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            return false;
        }
    }

    public Shift findShift(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Shift.class, id);
        }
    }
}
