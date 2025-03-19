package org.example.splitwise.impl;

import org.example.splitwise.ExpenseService;
import org.example.splitwise.database.DatabaseStrategy;
import org.example.splitwise.entities.Expense;
import org.example.splitwise.entities.Split;
import org.example.splitwise.entities.User;

import java.util.ArrayList;
import java.util.List;

public class EqualExpenseServcieImpl implements ExpenseService {

    private DatabaseStrategy db;

   public EqualExpenseServcieImpl(DatabaseStrategy databaseStrategy) {
        this.db = databaseStrategy;
    }

    @Override
    public boolean validateExpense(double amount, Integer paidUser, List<Integer> userIds, List<Double> userAmount) {

        if (amount < 0) {
            return false;
        }

        for (Integer userId : userIds) {
            User user = db.getUserById(userId);
            if (user == null) {
                return false;
            }
        }

        return true;

    }

    @Override
    public Expense addExpense(String name, double amount, Integer paidUser, List<Integer> userIds, List<Double> userAmount) {


        User payer = db.getUserById(paidUser);

        List<Integer> splitIds = new ArrayList<>();

        for (Integer payeeId : userIds) {
            if (payeeId == paidUser) {
                continue;
            }
            User payee = db.getUserById(payeeId);

            Split split = new Split(paidUser, payeeId, amount / userIds.size());

            payer.setSplitIds(split.getId());
            payee.setSplitIds(split.getId());
            splitIds.add(split.getId());
            db.insertSplit(split);
        }
        Expense expense = new Expense(name, amount, splitIds);
        db.insertExpense(expense);
        return expense;


    }
}
