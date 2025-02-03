package dev.rajnish.SplitWise.dto;

import dev.rajnish.SplitWise.model.constants.UserExpenseType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserExpenseResponseDTO {

    private int id;
    private String user;
    private double amount;
    private UserExpenseType userExpenseType;
    
}
