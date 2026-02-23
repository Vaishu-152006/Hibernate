package com.kce.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="VOLUNTEER_TBL")
public class Volunteer {

    @Id
    @Column(name="VOLUNTEER_ID")
    private String volunteerID;

    @Column(name="FULL_NAME")
    private String fullName;

    @Column(name="PRIMARY_PHONE")
    private String primaryPhone;

    @Column(name="EMAIL")
    private String email;

    @Column(name="SKILL_CATEGORY")
    private String skillCategory;

    @Column(name="STATUS")
    private String status;

    @OneToMany(mappedBy="volunteer", cascade=CascadeType.ALL)
    private List<Assignment> assignments;

    public String getVolunteerID() {
        return volunteerID;
    }

    public void setVolunteerID(String volunteerID) {
        this.volunteerID = volunteerID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPrimaryPhone() {
        return primaryPhone;
    }

    public void setPrimaryPhone(String primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkillCategory() {
        return skillCategory;
    }

    public void setSkillCategory(String skillCategory) {
        this.skillCategory = skillCategory;
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