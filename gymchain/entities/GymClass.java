package org.example.gymchain.entities;

import com.sun.jdi.FloatType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GymClass {

    private static int uniqueClassId = 0;

    private Integer id;
    private Integer gymId;
    private int maxlimit;
    private int startTime;
    private int endTime;
    Set<Integer> bookings;

    public GymClass(Integer gymId, int maxlimit, int startTime, int endTime) {
        this.id = ++uniqueClassId;
        this.gymId = gymId;
        this.maxlimit = maxlimit;
        this.startTime = startTime;
        this.endTime = endTime;
        this.bookings = new HashSet<>();
    }

    public Integer getId() {
        return id;
    }

    public Integer getGymId() {
        return gymId;
    }

    public void setGymId(Integer gymId) {
        this.gymId = gymId;
    }

    public int getMaxlimit() {
        return maxlimit;
    }

    public void setMaxlimit(int maxlimit) {
        this.maxlimit = maxlimit;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public Set<Integer> getBookings() {
        return bookings;
    }

    public void removeBooking(Integer bookingId) {
        this.bookings.remove(bookingId);
    }


    public void setBookings(Integer bookingId) {
        this.bookings.add(bookingId);
    }
}
