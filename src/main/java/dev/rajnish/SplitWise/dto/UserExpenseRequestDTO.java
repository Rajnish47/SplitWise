package dev.rajnish.SplitWise.dto;

import dev.rajnish.SplitWise.model.constants.UserExpenseType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserExpenseRequestDTO {
    
    private int userId;
    private double amount;
    private UserExpenseType userExpenseType;
}
