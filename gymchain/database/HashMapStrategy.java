package org.example.gymchain.database;

import org.example.gymchain.CustomerInterface;
import org.example.gymchain.entities.Booking;
import org.example.gymchain.entities.Customer;
import org.example.gymchain.entities.Gym;
import org.example.gymchain.entities.GymClass;

import java.util.HashMap;
import java.util.List;

public class HashMapStrategy extends DatabaseStrategy {


    final private HashMap<Integer, Customer> customers;
    final private HashMap<Integer, Gym> gyms;
    final private HashMap<Integer, GymClass> gymClasses;
    final private HashMap<Integer, Booking> bookings;


    public HashMapStrategy() {
        customers = new HashMap<>();
        gyms = new HashMap<>();
        gymClasses = new HashMap<>();
        bookings = new HashMap<>();
    }

    @Override
    public Customer findCustomer(Integer customer_id) {
        return customers.get(customer_id);
    }

    @Override
    public Booking findBooking(Integer booking_id) {
        return bookings.get(booking_id);
    }

    @Override
    public Gym findGym(Integer gym_id) {
        return gyms.get(gym_id);
    }

    @Override
    public GymClass findGymClass(Integer gym_class_id) {
        return gymClasses.get(gym_class_id);
    }

    @Override
    public void createNewCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    @Override
    public void createNewBooking(Booking booking) {
        bookings.put(booking.getId(), booking);
    }

    @Override
    public void createNewGym(Gym gym) {
        gyms.put(gym.getId(), gym);
    }

    @Override
    public void createNewGymClass(GymClass gymClass) {
        gymClasses.put(gymClass.getId(), gymClass);
    }

    @Override
    public boolean deleteCustomer(Integer customer_id) {
        if (customers.containsKey(customer_id)) {
            customers.remove(customer_id);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteBooking(Integer booking_id) {
        if (bookings.containsKey(booking_id)) {
            bookings.remove(booking_id);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteGym(Integer gym_id) {
        if (gyms.containsKey(gym_id)) {
            gyms.remove(gym_id);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteGymClass(Integer gym_class_id) {
        if (gymClasses.containsKey(gym_class_id)) {
            gymClasses.remove(gym_class_id);
            return true;
        }
        return false;
    }
}
