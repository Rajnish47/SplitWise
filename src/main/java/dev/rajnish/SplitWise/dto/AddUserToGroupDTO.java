package dev.rajnish.SplitWise.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserToGroupDTO {
    
    private Integer groupId;
    private Integer userId;
}
