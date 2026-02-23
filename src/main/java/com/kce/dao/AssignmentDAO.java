package com.kce.dao;

import java.sql.Date;
import java.util.List;
import org.hibernate.Session;
import com.kce.entity.Assignment;
import com.kce.util.HibernateUtil;

public class AssignmentDAO {

	public boolean hasOverlap(String volunteerID,
            Date date,
            String start,
            String end, Session session) {

List<Assignment> list = session.createQuery(
"FROM Assignment a WHERE a.volunteer.volunteerID=:vid " +
"AND a.shift.shiftDate=:dt " +
"AND a.shift.startTime < :end " +
"AND a.shift.endTime > :start",
Assignment.class)
.setParameter("vid", volunteerID)
.setParameter("dt", date)
.setParameter("start", start)
.setParameter("end", end)
.list();


return !list.isEmpty();

    }

	public boolean hasOverlap(String vid, Date shiftDate, String startTime, String endTime) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
