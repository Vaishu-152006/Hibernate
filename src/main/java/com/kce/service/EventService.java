package com.kce.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.kce.dao.*;
import com.kce.entity.*;
import com.kce.util.*;

public class EventService {

    private VolunteerDAO volunteerDAO = new VolunteerDAO();
    private ShiftDAO shiftDAO = new ShiftDAO();
    private AssignmentDAO assignmentDAO = new AssignmentDAO();

    
    public boolean registerNewVolunteer(Volunteer v) throws Exception {

        if (v.getVolunteerID() == null || v.getFullName() == null)
            throw new ValidationException();

        v.setStatus("ACTIVE");

        return volunteerDAO.insertVolunteer(v);
    }

   
    public boolean createShift(Shift s) throws Exception {

        if (s.getShiftDate() == null)
            throw new ValidationException();

        return shiftDAO.insertShift(s);
    }

    public boolean assignVolunteerToShift(String vid, int sid, String role)
            throws Exception {

        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            Volunteer v = session.get(Volunteer.class, vid);
            Shift s = session.get(Shift.class, sid);

            if (v == null || s == null) {
                tx.rollback();
                return false;
            }

           
            boolean overlap = assignmentDAO.hasOverlap(
                    vid,
                    s.getShiftDate(),
                    s.getStartTime(),
                    s.getEndTime()
            );

            if (overlap) {
                tx.rollback();
                throw new OverlappingShiftAssignmentException();
            }

            Assignment a = new Assignment();
            a.setVolunteer(v);
            a.setShift(s);
            a.setAssignedRole(role);
            a.setAttendanceStatus("PENDING");

            session.persist(a);

            tx.commit();
            return true;

        } catch (Exception e) {

            if (tx != null)
                tx.rollback();

            throw e;
        }
    }
}