package org.example.splitwise.entities;

import java.util.List;

public class Expense {
    private static Integer uniqueExpenseId = 0;
    private Integer id;
    private String name;
    private Double amount;
    private List<Integer> splitIds;
    private Integer paidUser;

    public Expense(String name, Double amount, List<Integer> splitIds) {
        this.id = uniqueExpenseId++;
        this.name = name;
        this.amount = amount;
        this.splitIds = splitIds;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public List<Integer> getSplitIds() {
        return splitIds;
    }

    public void setSplitIds(List<Integer> splitIds) {
        this.splitIds = splitIds;
    }

    public Integer getPaidUser() {
        return paidUser;
    }

    public void setPaidUser(Integer paidUser) {
        this.paidUser = paidUser;
    }
}
