package dev.rajnish.SplitWise.mapper;

import java.time.LocalDateTime;

import dev.rajnish.SplitWise.dto.ExpenseRequestDTO;
import dev.rajnish.SplitWise.dto.GroupRequestDTO;
import dev.rajnish.SplitWise.dto.UserSignUpRequestDTO;
import dev.rajnish.SplitWise.model.Expense;
import dev.rajnish.SplitWise.model.Group;
import dev.rajnish.SplitWise.model.User;

public class DTOtoEntityMapper {
    
    public static User userDTOToEntity(UserSignUpRequestDTO userSignUpRequestDTO)
    {
        User user = new User();
        user.setEmail(userSignUpRequestDTO.getEmail());
        user.setPassword(userSignUpRequestDTO.getPassword());
        user.setName(userSignUpRequestDTO.getName());

        return user;        
    }

    public static Group groupDTOToEntity(GroupRequestDTO groupRequestDTO)
    {
        Group group = new Group();
        group.setName(groupRequestDTO.getName());
        group.setDescription(groupRequestDTO.getDescription());

        return group;
    }

    public static Expense expenseDTOToEntity(ExpenseRequestDTO expenseRequestDTO)
    {
        Expense expense = new Expense();
        expense.setAmount(expenseRequestDTO.getAmount());
        expense.setCurrency(expenseRequestDTO.getCurrency());
        expense.setDescription(expenseRequestDTO.getDescription());
        expense.setExpenseTime(LocalDateTime.now());
        expense.setSplitStratergy(expenseRequestDTO.getSplitStratergy());

        return expense;
    }
}
