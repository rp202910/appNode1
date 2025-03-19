package org.example.splitwise.impl;

import org.example.splitwise.ExpenseService;
import org.example.splitwise.database.DatabaseStrategy;
import org.example.splitwise.entities.Expense;
import org.example.splitwise.entities.Split;
import org.example.splitwise.entities.User;

import java.util.ArrayList;
import java.util.List;

public class PercentageExpenseServcieImpl implements ExpenseService {

    private DatabaseStrategy db;

    public PercentageExpenseServcieImpl(DatabaseStrategy db) {
        this.db = db;
    }


    @Override
    public boolean validateExpense(double amount, Integer paidUser, List<Integer> userIds, List<Double> userAmounts) {
        if (amount < 0) {
            return false;
        }

        for (Integer userId : userIds) {
            User user = db.getUserById(userId);
            if (user == null) {
                return false;
            }
        }

        Double amountAdded = 0.0;
        for (Double userAmount : userAmounts) {
            amountAdded += userAmount;
        }
        return amountAdded == 100.0;
    }

    @Override
    public Expense addExpense(String name, double amount, Integer paidUser, List<Integer> userIds, List<Double> userAmount) {
        User payer = db.getUserById(paidUser);

        List<Integer> splitIds = new ArrayList<>();
        int userNo = 0;
        for (Integer payeeId : userIds) {
            if (payeeId.equals(paidUser)) {
                continue;
            }
            User payee = db.getUserById(payeeId);

            Split split = new Split(paidUser, payeeId, (userAmount.get(userNo) * amount) / 100);

            payer.setSplitIds(split.getId());
            payee.setSplitIds(split.getId());
            splitIds.add(split.getId());
            db.insertSplit(split);
            userNo++;
        }
        Expense expense = new Expense(name, amount, splitIds);
        db.insertExpense(expense);
        return expense;
    }
}
