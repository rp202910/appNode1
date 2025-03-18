package org.example.gymchain.database;

import org.example.gymchain.entities.Booking;
import org.example.gymchain.entities.Customer;
import org.example.gymchain.entities.Gym;
import org.example.gymchain.entities.GymClass;

public abstract class DatabaseStrategy {

    public abstract Customer findCustomer(Integer customer_id);

    public abstract Booking findBooking(Integer booking_id);

    public abstract Gym findGym(Integer gym_id);

    public abstract GymClass findGymClass(Integer gym_class_id);

    public abstract void createNewCustomer(Customer customer);

    public abstract void createNewBooking(Booking booking);

    public abstract void createNewGym(Gym gym);

    public abstract void createNewGymClass(GymClass gymClass);

    public abstract boolean deleteCustomer(Integer customer_id);

    public abstract boolean deleteBooking(Integer booking_id);

    public abstract boolean deleteGym(Integer gym_id);

    public abstract boolean deleteGymClass(Integer gym_class_id);


}
