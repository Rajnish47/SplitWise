package dev.rajnish.SplitWise.service;

import dev.rajnish.SplitWise.model.UserExpense;

public interface UserExpenseService {
    public UserExpense addUserExpense(UserExpense userExpense);
    public void deleteUserExpense(int id);
}
