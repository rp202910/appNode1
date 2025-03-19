package org.example.splitwise.database;

import org.example.splitwise.entities.Expense;
import org.example.splitwise.entities.Split;
import org.example.splitwise.entities.User;

public interface DatabaseStrategy {

    public Expense getExpenseById(Integer id);

    public Split getSplitById(Integer id);

    public User getUserById(Integer id);

    public void insertExpense(Expense expense);

    public void insertSplit(Split split);

    public void insertUser(User user);

}
