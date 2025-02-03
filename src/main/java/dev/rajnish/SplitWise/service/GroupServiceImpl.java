package dev.rajnish.SplitWise.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.rajnish.SplitWise.model.Group;
import dev.rajnish.SplitWise.model.User;
import dev.rajnish.SplitWise.repository.GroupRepository;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserService userService;

    @Override
    public Group createGroup(Group group,int userId) {

        User user = userService.findUserByID(userId);
        List<Group> useGroups = user.getGroups();
        List<User> groupMembers = new ArrayList<>();
        groupMembers.add(user); // adding the creater to the group
        group.setGroupMembers(groupMembers);

        Group savedGroup = groupRepository.save(group);
        if(useGroups==null)
        {
            useGroups=new ArrayList<>();
        }

        useGroups.add(savedGroup); //adding the group to the group list under user
        userService.updateUser(user);

        return savedGroup;
    }

    @Override
    public void deleteGroup(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteGroup'");
    }

    @Override
    public Group updateGroup(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Group getGroupById(int id) {
        return groupRepository.findById(id).get();
    }

    @Override
    public Group addUserToGroup(int groupId, int userId) {
        User savedUser = userService.findUserByID(userId);
        Group savedGroup = groupRepository.findById(groupId).get();

        List<User> groupMembers = savedGroup.getGroupMembers();
        groupMembers.add(savedUser);
        savedGroup.setGroupMembers(groupMembers);
        updateGroup(savedGroup);

        List<Group> userGroups = savedUser.getGroups();
        userGroups.add(savedGroup);
        savedUser.setGroups(userGroups);
        userService.updateUser(savedUser);

        return savedGroup;
    }    
}
