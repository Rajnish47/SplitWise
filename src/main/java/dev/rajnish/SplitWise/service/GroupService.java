package dev.rajnish.SplitWise.service;

import dev.rajnish.SplitWise.model.Group;

public interface GroupService {
    
    public Group createGroup(Group group,int userId);
    public Group updateGroup(Group group);
    public void deleteGroup(int id);
}
