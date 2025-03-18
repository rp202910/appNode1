package org.example.gymchain.impl;

import org.example.gymchain.AdminInterface;
import org.example.gymchain.CustomerInterface;
import org.example.gymchain.database.DatabaseStrategy;
import org.example.gymchain.entities.Gym;
import org.example.gymchain.entities.GymClass;

import java.util.Set;

public class AdminFuncImpl implements AdminInterface {

    DatabaseStrategy db;

    public AdminFuncImpl(DatabaseStrategy strategy) {
        this.db = strategy;
    }

    @Override
    public Integer add_gym(String name, String location, Integer maxAccom) {
        Gym gym = new Gym(name, location, maxAccom);
        db.createNewGym(gym);
        return gym.getId();
    }

    @Override
    public boolean remove_gym(Integer gymId) {

        Gym gym = db.findGym(gymId);
        if (gym == null) {
            return false;
        }

        for (Integer classId : gym.getClasses()) {
            removeClass(gymId, classId);
        }
        return db.deleteGym(gymId);

    }

    @Override
    public Integer addClass(Integer gym_id, String class_type, Integer max_limit, Integer start_time, Integer end_time) {

        try {

            Gym gym = db.findGym(gym_id);
            if (!validateGymLimitAtThatTime(gym, start_time, end_time, max_limit)) {
                return -1;
            }

            GymClass gymClass = new GymClass(gym_id, max_limit, start_time, end_time);
            db.createNewGymClass(gymClass);

            gym.setClassIds(gymClass.getId());


            return gymClass.getId();


        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }
    }

    @Override
    public boolean removeClass(Integer gym_id, Integer class_id) {

        Gym gym = db.findGym(gym_id);
        if (gym == null) {
            return false;
        }
        GymClass gymClass = db.findGymClass(class_id);
        if (gymClass == null) {
            return false;
        }

        CustomerInterface customerInterface = new CustomerFuncImpl(db);

        for (Integer bookingId : gymClass.getBookings()) {
            customerInterface.cancelBooking(bookingId);
        }
        gym.removeClass(class_id);
        return db.deleteGymClass(class_id);
    }

    boolean validateGymLimitAtThatTime(Gym gym, Integer start_time, Integer end_time, Integer classLimit) {

        Set<Integer> classIds = gym.getClasses();
        int capacityOfGymUtilisedAtThatTime = 0;
        for (Integer classId : classIds) {
            GymClass gymClass = db.findGymClass(classId);
            if (gymClass != null) {
                if (!(gymClass.getStartTime() > end_time || gymClass.getEndTime() < start_time)) {
                    capacityOfGymUtilisedAtThatTime += gymClass.getMaxlimit();
                }
            }
        }
        return capacityOfGymUtilisedAtThatTime + classLimit <= gym.getMax_limit();
    }
}
