package org.example.gymchain.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Customer {

    private static int uniqueBookingId = 0;
    final private Set<Integer> classIdsAlreadyRegistered;

    private Integer id;
    final private Set<Integer> bookings;

    public Customer() {
        bookings = new HashSet<>();
        classIdsAlreadyRegistered = new HashSet<>();
        id = uniqueBookingId++;
    }


    public Set<Integer> getClassIdsAlreadyRegistered() {
        return classIdsAlreadyRegistered;
    }

    public void setClassIdsAlreadyRegistered(Integer classId) {
        classIdsAlreadyRegistered.add(classId);
    }

    public void removeClassIdAlreadyRegistered(Integer classId) {
        classIdsAlreadyRegistered.remove(classId);
    }

    public void removeBookingIds(Integer uniqueBookingId) {
        bookings.remove(uniqueBookingId);

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Set<Integer> getBookings() {
        return bookings;
    }

    public void setBookings(Integer bookingId) {
        bookings.add(bookingId);
    }

}
