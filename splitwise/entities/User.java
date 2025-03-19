package org.example.splitwise.entities;

import java.util.ArrayList;
import java.util.List;

public class User {

    static private Integer uniqueUserId = 0;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Integer> getSplitIds() {
        return splitIds;
    }

    public void setSplitIds(Integer splitId) {
        splitIds.add(splitId);
    }

    private Integer id;
    private String username;

    private List<Integer> splitIds;

    public User(String username) {
        this.id = uniqueUserId++;
        this.username = username;
        this.splitIds = new ArrayList<>();
    }


}
