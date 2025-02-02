package dev.rajnish.SplitWise.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginResponseDTO {

    private int id;
    private String name;
    private String email;
    private List<GroupResponseDTO> groups;
    private List<FriendResponseDTO> friends;    
}
