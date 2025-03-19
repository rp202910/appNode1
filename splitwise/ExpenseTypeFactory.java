package org.example.splitwise;

import org.example.splitwise.database.DatabaseStrategy;
import org.example.splitwise.entities.Expense;
import org.example.splitwise.enums.ExpenseTypeEnum;
import org.example.splitwise.impl.EqualExpenseServcieImpl;
import org.example.splitwise.impl.ExactExpenseServcieImpl;
import org.example.splitwise.impl.PercentageExpenseServcieImpl;

public class ExpenseTypeFactory {

    public static ExpenseService getExpense(ExpenseTypeEnum type, DatabaseStrategy db) {
        switch (type) {
            case EXACT:
                return new ExactExpenseServcieImpl(db);
            case EQUAL:
                return new EqualExpenseServcieImpl(db);
            case PERCENTAGE:
                return new PercentageExpenseServcieImpl(db);
        }

        return new ExactExpenseServcieImpl(db);
    }

}
