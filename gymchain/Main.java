package org.example.gymchain;

import org.example.gymchain.database.DatabaseStrategy;
import org.example.gymchain.database.HashMapStrategy;
import org.example.gymchain.entities.Booking;
import org.example.gymchain.entities.Customer;
import org.example.gymchain.impl.AdminFuncImpl;
import org.example.gymchain.impl.CustomerFuncImpl;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        DatabaseStrategy databaseStrategy = new HashMapStrategy();

        AdminInterface adminFunc = new AdminFuncImpl(databaseStrategy);
        CustomerInterface customerInterface = new CustomerFuncImpl(databaseStrategy);


        Integer gymId = adminFunc.add_gym("MaxFitness", "Gurugram", 10);

        Integer classId1 = adminFunc.addClass(gymId, "Cardio", 5, 1000, 1030);

        Integer classId2 = adminFunc.addClass(gymId, "Zumba", 15, 1000, 1045);

        System.out.println("Class created " + classId1);
        System.out.println("Class created " + classId2);

        Customer customer = new Customer();
        databaseStrategy.createNewCustomer(customer);

        Integer bookingId1 = customerInterface.bookClass(customer.getId(), gymId, classId1);
        System.out.println("Booking created " + bookingId1);
        Integer bookingId2 = customerInterface.bookClass(customer.getId(), gymId, classId2);
        System.out.println("Booking created " + bookingId2);

        List<Booking> bookings = customerInterface.getAllBookings(customer.getId());
        for (Booking booking : bookings) {
            System.out.println("Booking: " + booking);
        }

        boolean cancelledBooking = customerInterface.cancelBooking(bookingId1);
        if(cancelledBooking) {
            System.out.println("Booking cancelled");
        }
        List<Booking> bookings1 = customerInterface.getAllBookings(customer.getId());
        for (Booking booking : bookings1) {
            System.out.println("Booking: " + booking);
        }


    }
}
