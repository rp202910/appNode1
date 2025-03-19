package org.example.splitwise;

import org.example.splitwise.database.DatabaseStrategy;
import org.example.splitwise.database.HashMapStrategy;
import org.example.splitwise.entities.Expense;
import org.example.splitwise.entities.Split;
import org.example.splitwise.entities.User;
import org.example.splitwise.enums.ExpenseTypeEnum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitWise {

    private DatabaseStrategy db;
    private static SplitWise instance;


    private SplitWise() {
        db = new HashMapStrategy();
    }

    public static SplitWise getInstance() {
        if (instance == null) {
            instance = new SplitWise();
        }
        return instance;

    }

    public User addUser(String userName) {
        User user = new User(userName);
        db.insertUser(user);
        return user;
    }

    public Expense addExpense(String name, double amount, Integer paidUser, List<Integer> userIds, List<Double> userValues, ExpenseTypeEnum expenseType) {

        if (ExpenseTypeFactory.getExpense(expenseType, db).validateExpense(amount, paidUser, userIds, userValues)) {
            return ExpenseTypeFactory.getExpense(expenseType, db).addExpense(name, amount, paidUser, userIds, userValues);
        }
        return null;
    }

    public void userBalance(User user) {

        List<Integer> splitIds = user.getSplitIds();

        Map<Integer, Double> usersHistory = new HashMap<>();

        for (Integer splitId : splitIds) {

            Split split = db.getSplitById(splitId);
            if (split.getPayeeUserId().equals(user.getId())) {

                usersHistory.put(split.getPayerUserId(), usersHistory.getOrDefault(split.getPayerUserId(), 0.0) - split.getAmount());
            } else {
                usersHistory.put(split.getPayeeUserId(), usersHistory.getOrDefault(split.getPayeeUserId(), 0.0) + split.getAmount());
            }

        }

        for (Map.Entry<Integer, Double> entry : usersHistory.entrySet()) {

            User otherUser = db.getUserById(entry.getKey());

            if (entry.getValue() < 0) {
                System.out.println("User  : " + user.getUsername() + " have to give money "+ entry.getValue()+  "to " +  otherUser.getUsername());
            } else
                System.out.println("User  : " + user.getUsername() + " needs to take money "+ entry.getValue()+  " from " + otherUser.getUsername());

        }


    }


}
