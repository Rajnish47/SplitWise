package dev.rajnish.SplitWise.mapper;

import java.util.ArrayList;
import java.util.List;

import dev.rajnish.SplitWise.dto.FriendResponseDTO;
import dev.rajnish.SplitWise.dto.GroupResponseDTO;
import dev.rajnish.SplitWise.dto.UserLoginResponseDTO;
import dev.rajnish.SplitWise.model.Group;
import dev.rajnish.SplitWise.model.User;

public class EntityToDTOMapper {
    
    public static UserLoginResponseDTO userEntityToDTO(User user)
    {
        UserLoginResponseDTO userLoginResponseDTO = new UserLoginResponseDTO();
        userLoginResponseDTO.setId(user.getId());
        userLoginResponseDTO.setName(user.getName());
        userLoginResponseDTO.setEmail(user.getEmail());
        
        List<GroupResponseDTO> groups = new ArrayList<>();
        for(Group group: user.getGroups())
        {
            groups.add(groupEntityToDTO(group));            
        }

        userLoginResponseDTO.setGroups(groups);

        List<FriendResponseDTO> friends = new ArrayList<>();
        for(User friend: user.getFriends())
        {
            friends.add(friendEntityToDTO(friend));
        }

        userLoginResponseDTO.setFriends(friends);

        return userLoginResponseDTO;        
    }

    public static GroupResponseDTO groupEntityToDTO(Group group)
    {
        GroupResponseDTO groupResponseDTO = new GroupResponseDTO();
        groupResponseDTO.setId(group.getId());
        groupResponseDTO.setName(group.getName());
        groupResponseDTO.setDescription(group.getDescription());

        return groupResponseDTO;
    }

    public static FriendResponseDTO friendEntityToDTO(User user)
    {
        FriendResponseDTO friendResponseDTO = new FriendResponseDTO();
        friendResponseDTO.setId(user.getId());
        friendResponseDTO.setName(user.getName());

        return friendResponseDTO;
    }
}
