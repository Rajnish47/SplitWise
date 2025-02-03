package dev.rajnish.SplitWise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.rajnish.SplitWise.dto.ExpenseRequestDTO;
import dev.rajnish.SplitWise.mapper.DTOtoEntityMapper;
import dev.rajnish.SplitWise.model.Expense;
import dev.rajnish.SplitWise.service.ExpenseService;

@RestController
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/expense/add")
    public ResponseEntity addExpense(@RequestBody ExpenseRequestDTO expenseRequestDTO)
    {
        Expense expense = DTOtoEntityMapper.expenseDTOToEntity(expenseRequestDTO);
        expenseService.addExpense(expense,expenseRequestDTO.getUserExpenses(), expenseRequestDTO.getGroupId(), expenseRequestDTO.getCreatedBy());

        return ResponseEntity.ok("Expense created");
    }    
}
