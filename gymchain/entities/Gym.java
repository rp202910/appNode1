package org.example.gymchain.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Gym {

    private static int uniqueGymId = 0;

    private int id;
    private String name;
    private String location;
    private Set<Integer> classes;
    private Integer max_limit;
    public Gym(String name, String location, Integer maxLimit) {

        id = uniqueGymId++;
        this.name = name;
        this.location = location;
        classes = new HashSet<>();
        max_limit = maxLimit;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<Integer> getClasses() {
        return classes;
    }

    public void setClassIds(Integer classId) {
        classes.add(classId);
    }

    public Integer getMax_limit() {
        return max_limit;
    }

    public void setMax_limit(Integer max_limit) {
        this.max_limit = max_limit;
    }

    public void removeClass(Integer class_id) {
        classes.remove(class_id);
    }

}
