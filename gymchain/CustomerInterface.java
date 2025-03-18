package org.example.gymchain;

import org.example.gymchain.entities.Booking;

import java.util.List;

public interface CustomerInterface {
    Integer bookClass(Integer customer_id, Integer gym_id, Integer class_id);

    List<Booking> getAllBookings(Integer customerId);

    boolean cancelBooking(Integer booking_id);

}
