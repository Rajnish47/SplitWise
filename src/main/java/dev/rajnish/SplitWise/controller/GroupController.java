package dev.rajnish.SplitWise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.rajnish.SplitWise.dto.AddUserToGroupDTO;
import dev.rajnish.SplitWise.dto.GroupRequestDTO;
import dev.rajnish.SplitWise.dto.GroupResponseDTO;
import dev.rajnish.SplitWise.exception.InvalidDetailsException;
import dev.rajnish.SplitWise.mapper.DTOtoEntityMapper;
import dev.rajnish.SplitWise.mapper.EntityToDTOMapper;
import dev.rajnish.SplitWise.model.Group;
import dev.rajnish.SplitWise.service.GroupService;

@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;


    private void validateGroupDetails(Group group,int userId)
    {
        String name = group.getName();
        if(name==null || name.isEmpty() || name.isBlank())
        {
            throw new InvalidDetailsException("Invalid group name");
        }

        if(userId<=0)
        {
            throw new InvalidDetailsException("Invalid user id details");
        }
    }

    @PostMapping("/group/create")
    public ResponseEntity createGroup(@RequestBody GroupRequestDTO groupRequestDTO)
    {
        Group group = DTOtoEntityMapper.groupDTOToEntity(groupRequestDTO);
        validateGroupDetails(group,groupRequestDTO.getUserId());
        groupService.createGroup(group,groupRequestDTO.getUserId());
        
        return ResponseEntity.ok("Group created successfully");
    }
    
    @GetMapping("/group/{id}")
    public ResponseEntity getGroup(@PathVariable("id") int groupId)
    {
        Group group = groupService.getGroupById(groupId);
        GroupResponseDTO groupResponseDTO = EntityToDTOMapper.groupEntityToDTO(group);
        return ResponseEntity.ok(groupResponseDTO);        
    }

    @PostMapping("/group/adduser")
    public ResponseEntity addUserToGroup(@RequestBody AddUserToGroupDTO addUserToGroupDTO)
    {
        groupService.addUserToGroup(addUserToGroupDTO.getGroupId(), addUserToGroupDTO.getUserId());
        return ResponseEntity.ok("User added to group successfully");
    }
}
