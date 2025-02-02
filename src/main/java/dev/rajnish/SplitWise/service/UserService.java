package dev.rajnish.SplitWise.service;

import dev.rajnish.SplitWise.model.User;

public interface UserService {

    public User userSignUp(User user);
    public User userLogin(String email,String password);
    public User findUserByID(int id);
    public User updateUser(User user);    
}
