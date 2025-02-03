package dev.rajnish.SplitWise.dto;

import java.util.Currency;
import java.util.List;

import dev.rajnish.SplitWise.model.constants.SplitStratergy;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpenseRequestDTO {

    private int groupId;
    private double amount;
    private SplitStratergy splitStratergy;
    private Currency currency;
    private String description;
    private int createdBy;
    private List<UserExpenseRequestDTO> userExpenses;    
}
