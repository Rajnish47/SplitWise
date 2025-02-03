package dev.rajnish.SplitWise.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.rajnish.SplitWise.dto.UserExpenseRequestDTO;
import dev.rajnish.SplitWise.model.Expense;
import dev.rajnish.SplitWise.model.Group;
import dev.rajnish.SplitWise.model.User;
import dev.rajnish.SplitWise.model.UserExpense;
import dev.rajnish.SplitWise.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private UserExpenseService userExpenseService;
    @Autowired
    private GroupService groupService;

    @Override
    public Expense addExpense(Expense expense,List<UserExpenseRequestDTO> userExpenseDTOs,int groupId,int userId) {

        List<UserExpense> userExpenses = new ArrayList<>();
        expense.setAddedBy(userService.findUserByID(userId));

        for(UserExpenseRequestDTO useExpenseDTO: userExpenseDTOs)
        {
            UserExpense userExpense = new UserExpense();
            User user = userService.findUserByID(useExpenseDTO.getUserId());
            userExpense.setUser(user);
            userExpense.setAmount(useExpenseDTO.getAmount());
            userExpense.setUserExpenseType(useExpenseDTO.getUserExpenseType());
            UserExpense savedUserExpense = userExpenseService.addUserExpense(userExpense);
            userExpenses.add(savedUserExpense);
        }

        expense.setUserExpenses(userExpenses);
        Expense savedExpense = expenseRepository.save(expense);
        Group savedGroup = groupService.getGroupById(groupId);
        List<Expense> groupExpenses = savedGroup.getExpenses();
        if(groupExpenses==null)
        {
            groupExpenses = new ArrayList<>();
        }
        groupExpenses.add(savedExpense);
        savedGroup.setExpenses(groupExpenses);
        groupService.updateGroup(savedGroup);
        
        return expenseRepository.save(expense);
    }

    @Override
    public void deleteExpense(Expense expense) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteExpense'");
    }
    
}
