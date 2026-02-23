package com.kce.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ASSIGNMENT_TBL")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "assignment_seq_gen")
    @SequenceGenerator(
            name = "assignment_seq_gen",
            sequenceName = "ASSIGNMENT_SEQ",
            allocationSize = 1
    )
    @Column(name = "ASSIGNMENT_ID")
    private int assignmentID;

    @ManyToOne
    @JoinColumn(name = "VOLUNTEER_ID")
    private Volunteer volunteer;

    @ManyToOne
    @JoinColumn(name = "SHIFT_ID")
    private Shift shift;

    @Column(name = "ASSIGNED_ROLE")
    private String assignedRole;

    @Column(name = "ATTENDANCE_STATUS")
    private String attendanceStatus;

    @Column(name = "CHECKIN_TIME")
    private String checkinTime;

    @Column(name = "CHECKOUT_TIME")
    private String checkoutTime;

    public int getAssignmentID() {
        return assignmentID;
    }

    public void setAssignmentID(int assignmentID) {
        this.assignmentID = assignmentID;
    }

    public Volunteer getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(Volunteer volunteer) {
        this.volunteer = volunteer;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public String getAssignedRole() {
        return assignedRole;
    }

    public void setAssignedRole(String assignedRole) {
        this.assignedRole = assignedRole;
    }

    public String getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(String attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    public String getCheckinTime() {
        return checkinTime;
    }

    public void setCheckinTime(String checkinTime) {
        this.checkinTime = checkinTime;
    }

    public String getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(String checkoutTime) {
        this.checkoutTime = checkoutTime;
    }
}