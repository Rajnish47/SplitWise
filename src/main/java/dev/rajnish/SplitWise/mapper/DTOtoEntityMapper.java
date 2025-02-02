package dev.rajnish.SplitWise.mapper;

import dev.rajnish.SplitWise.dto.GroupRequestDTO;
import dev.rajnish.SplitWise.dto.UserSignUpRequestDTO;
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
}
