package org.example.gymchain;

public interface AdminInterface {
    Integer add_gym(String name, String location, Integer maxAccom);

    boolean remove_gym(Integer gymId);

    Integer addClass(Integer gym_id, String class_type, Integer max_limit, Integer start_time, Integer end_time);

    boolean removeClass(Integer gym_id, Integer class_id);
}
