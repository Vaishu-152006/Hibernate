package com.kce.entity;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="SHIFT_TBL")
public class Shift {

    @Id
    @Column(name="SHIFT_ID")
    private int shiftID;

    @Column(name="SHIFT_DATE")
    private Date shiftDate;

    @Column(name="START_TIME")
    private String startTime;

    @Column(name="END_TIME")
    private String endTime;

    @Column(name="LOCATION")
    private String location;

    @Column(name="REQUIRED_HEADCOUNT")
    private int requiredHeadcount;

    @Column(name="STATUS")
    private String status;

    @OneToMany(mappedBy="shift", cascade=CascadeType.ALL)
    private List<Assignment> assignments;


    public int getShiftID() {
        return shiftID;
    }

    public void setShiftID(int shiftID) {
        this.shiftID = shiftID;
    }

    public Date getShiftDate() {
        return shiftDate;
    }

    public void setShiftDate(Date shiftDate) {
        this.shiftDate = shiftDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getRequiredHeadcount() {
        return requiredHeadcount;
    }

    public void setRequiredHeadcount(int requiredHeadcount) {
        this.requiredHeadcount = requiredHeadcount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }
}