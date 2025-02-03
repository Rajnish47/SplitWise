package dev.rajnish.SplitWise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.rajnish.SplitWise.model.UserExpense;
import dev.rajnish.SplitWise.repository.UserExpenseRepository;

@Service
public class UserExpenseServiceImpl implements UserExpenseService {

    @Autowired
    private UserExpenseRepository userExpenseRepository;

    @Override
    public UserExpense addUserExpense(UserExpense userExpense) {
        return userExpenseRepository.save(userExpense);
    }

    @Override
    public void deleteUserExpense(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUserExpense'");
    }
    
}
