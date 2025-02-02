package dev.rajnish.SplitWise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.rajnish.SplitWise.dto.GroupRequestDTO;
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
        Group savedGroup = groupService.createGroup(group,groupRequestDTO.getUserId());
        
        return ResponseEntity.ok(EntityToDTOMapper.groupEntityToDTO(savedGroup));
    }    
}
