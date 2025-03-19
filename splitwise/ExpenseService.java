package org.example.splitwise;

import org.example.splitwise.entities.Expense;

import java.util.List;

public interface ExpenseService {
    public boolean validateExpense(double amount, Integer paidUser, List<Integer> userIds, List<Double> userAmount);

    public Expense addExpense(String name, double amount, Integer paidUser, List<Integer> userIds, List<Double> userAmount);
}
