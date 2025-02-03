package dev.rajnish.SplitWise.service;

import java.util.List;

import dev.rajnish.SplitWise.dto.UserExpenseRequestDTO;
import dev.rajnish.SplitWise.model.Expense;

public interface ExpenseService {
    
    public Expense addExpense(Expense expense,List<UserExpenseRequestDTO> userExpenseRequestDTO,int groupId,int userId);
    public void deleteExpense(Expense expense);
    
}
