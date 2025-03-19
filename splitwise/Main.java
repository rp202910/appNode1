package org.example.splitwise;

import org.example.splitwise.entities.Expense;
import org.example.splitwise.entities.User;
import org.example.splitwise.enums.ExpenseTypeEnum;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        SplitWise splitWise = SplitWise.getInstance();

        User roshan =  splitWise.addUser("Roshan");
        User nitin = splitWise.addUser("nitin");

        Expense expense1 = splitWise.addExpense("party",1200,nitin.getId(),List.of(roshan.getId(), nitin.getId()),List.of(600.0,600.0), ExpenseTypeEnum.EQUAL);

        User mica = splitWise.addUser("Mica");

        Expense expense2 = splitWise.addExpense("partywithdance",1000,nitin.getId(),List.of(mica.getId(), roshan.getId(), nitin.getId()),List.of(200.0,600.0,200.0), ExpenseTypeEnum.EXACT);

        splitWise.userBalance(nitin);
        splitWise.userBalance(roshan);
        splitWise.userBalance(mica);
        Expense expense3 = splitWise.addExpense("partywithdance",1200,roshan.getId(),List.of(roshan.getId(), nitin.getId()),List.of(100.0,0.0), ExpenseTypeEnum.PERCENTAGE);

        splitWise.userBalance(nitin);
        splitWise.userBalance(roshan);



    }
}
