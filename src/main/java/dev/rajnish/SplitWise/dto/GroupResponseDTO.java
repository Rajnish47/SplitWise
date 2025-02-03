package dev.rajnish.SplitWise.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupResponseDTO {

    private int id;
    private String name;
    private String description;
    private List<String> groupMembers;
    private List<ExpenseResponseDTO> expenseResponseDTOs;
}
