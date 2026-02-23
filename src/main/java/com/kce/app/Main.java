package com.kce.app;

import com.kce.entity.Shift;
import com.kce.entity.Volunteer;
import com.kce.service.EventService;
import com.kce.util.OverlappingShiftAssignmentException;
import com.kce.util.ValidationException;

public class Main {

    private static EventService eventService;

    public static void main(String[] args) {

        eventService = new EventService();

        System.out.println("----- EVENT VOLUNTEER SCHEDULING SYSTEM -----");

      
        try {

            Volunteer v = new Volunteer();

            v.setVolunteerID("VOL6003");
            v.setFullName("Arun Kumar");
            v.setSkillCategory("SECURITY");
            v.setPrimaryPhone("9876543210");
            v.setEmail("arun6001@gmail.com");
            v.setStatus("ACTIVE");

            boolean volunteerAdded = eventService.registerNewVolunteer(v);

            if (volunteerAdded)
                System.out.println("Volunteer Registered Successfully!");
            else
                System.out.println("Volunteer Registration Failed!");

        } catch (ValidationException e) {
            System.out.println("Validation Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("System Error: " + e.getMessage());
        }


        try {

            Shift s = new Shift();

            s.setShiftID(9002);
            s.setShiftDate(java.sql.Date.valueOf("2026-03-15"));
            s.setStartTime("09:00");
            s.setEndTime("12:00");
            s.setLocation("MAIN_HALL");
            s.setRequiredHeadcount(5);
            s.setStatus("OPEN_FOR_ASSIGNMENT");

            boolean shiftCreated = eventService.createShift(s);

            if (shiftCreated)
                System.out.println("Shift Created Successfully!");
            else
                System.out.println("Shift Creation Failed!");

        } catch (ValidationException e) {
            System.out.println("Validation Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("System Error: " + e.getMessage());
        }


     
        try {

            boolean assigned = eventService.assignVolunteerToShift(
                    "VOL6001",
                    9002,
                    "ENTRY_CHECK"
            );

            if (assigned)
                System.out.println("Volunteer Assigned Successfully!");
            else
                System.out.println("Assignment Failed!");

        } catch (OverlappingShiftAssignmentException e) {
            System.out.println("Assignment Error: Overlapping Shift!");
        } catch (ValidationException e) {
            System.out.println("Validation Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("System Error: " + e.getMessage());
        }

        System.out.println("----- PROCESS COMPLETED -----");
    }
}