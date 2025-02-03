package dev.rajnish.SplitWise.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpenseResponseDTO {

    private int id;
    private String createdBy;
    private double totalAmount;
    private List<UserExpenseResponseDTO> userExpenseResponseDTOs;    
}
