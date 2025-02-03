package dev.rajnish.SplitWise.service;

import dev.rajnish.SplitWise.model.Group;

public interface GroupService {
    
    public Group createGroup(Group group,int userId);
    public Group getGroupById(int id);
    public Group updateGroup(Group group);
    public Group addUserToGroup(int groupId,int userId);
    public void deleteGroup(int id);
}
