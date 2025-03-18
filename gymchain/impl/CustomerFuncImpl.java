package org.example.gymchain.impl;

import org.example.gymchain.CustomerInterface;
import org.example.gymchain.database.DatabaseStrategy;
import org.example.gymchain.database.HashMapStrategy;
import org.example.gymchain.entities.Booking;
import org.example.gymchain.entities.Customer;
import org.example.gymchain.entities.Gym;
import org.example.gymchain.entities.GymClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CustomerFuncImpl implements CustomerInterface {

        DatabaseStrategy db;

    public CustomerFuncImpl(DatabaseStrategy strategy) {
        db = strategy;
    }

    @Override
    public Integer bookClass(Integer customer_id, Integer gym_id, Integer class_id) {

        Customer customer = db.findCustomer(customer_id);
        GymClass gymClass = db.findGymClass(class_id);
        if (validateClassCanBeBooked(customer, gymClass)) {
            Booking booking = new Booking(customer_id, class_id, gym_id);
            db.createNewBooking(booking);
            gymClass.setBookings(booking.getId());
            customer.setClassIdsAlreadyRegistered(class_id);
            customer.setBookings(booking.getId());
            return booking.getId();
        } else {
            return -1;
        }
    }

    @Override
    public List<Booking> getAllBookings(Integer customerId) {

        List<Booking> bookings = new ArrayList<>();
        Customer customer = db.findCustomer(customerId);

        if (customer == null) {
            return bookings;
        }
        Set<Integer> bookingIds = db.findCustomer(customerId).getBookings();
        for (Integer bookingId : bookingIds) {
            Booking booking = db.findBooking(bookingId);
            bookings.add(booking);
        }
        return bookings;

    }

    @Override
    public boolean cancelBooking(Integer booking_id) {

        try {
            Booking booking = db.findBooking(booking_id);
            if (booking != null) {
                Customer customer = db.findCustomer(booking.getCustomerId());
                customer.removeClassIdAlreadyRegistered(booking.getClassId());
                customer.removeBookingIds(booking.getId());
                GymClass gymClass = db.findGymClass(booking.getClassId());
                if (gymClass != null) {
                    gymClass.removeBooking(booking.getId());
                }
                return db.deleteBooking(booking_id);

            } else {
                System.out.println("Booking not found");
            }
        } catch (Exception e) {
            System.out.println("Not able to cancel booking due to " + e.getMessage());
            return false;
        }
        return false;
    }

    private boolean validateClassCanBeBooked(Customer customer, GymClass gymClass) {
        if (customer == null || gymClass == null) {
            return false;
        }
        if (customer.getClassIdsAlreadyRegistered().contains(gymClass.getId())) {
            return false;
        }

        return gymClass.getBookings().size() < gymClass.getMaxlimit();
    }

}
