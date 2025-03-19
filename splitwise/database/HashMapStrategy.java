package org.example.splitwise.database;

import org.example.splitwise.entities.Expense;
import org.example.splitwise.entities.Split;
import org.example.splitwise.entities.User;

import java.util.HashMap;

public class HashMapStrategy implements DatabaseStrategy {

    private HashMap<Integer, Expense> expenses;
    private HashMap<Integer, User> users;
    private HashMap<Integer, Split> splits;

    public HashMapStrategy() {
        this.expenses = new HashMap<>();
        this.users = new HashMap<>();
        this.splits = new HashMap<>();
    }


    @Override
    public Expense getExpenseById(Integer id) {
        return expenses.get(id);
    }

    @Override
    public Split getSplitById(Integer id) {
        return splits.get(id);
    }

    @Override
    public User getUserById(Integer id) {
        return users.get(id);
    }

    @Override
    public void insertExpense(Expense expense) {
        expenses.put(expense.getId(), expense);
    }

    @Override
    public void insertSplit(Split split) {
        splits.put(split.getId(), split);
    }

    @Override
    public void insertUser(User user) {
        users.put(user.getId(), user);
    }
}
