package dev.rajnish.SplitWise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import dev.rajnish.SplitWise.exception.InvalidDetailsException;
import dev.rajnish.SplitWise.exception.NoUserFoundException;
import dev.rajnish.SplitWise.model.User;
import dev.rajnish.SplitWise.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User userSignUp(User user) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode(user.getPassword());
        user.setPassword(password);        

        return userRepository.save(user);
    }

    @Override
    public User userLogin(String email, String password) {

        User user = userRepository.getUserByEmail(email);
        if(user==null)
        {
            throw new NoUserFoundException("No user with the given email");
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(!encoder.matches(password, user.getPassword()))
        {
            throw new InvalidDetailsException("Invalid password");
        }

        return user;
    }

    @Override
    public User findUserByID(int id) {
        
        return userRepository.findById(id).get();
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }    
}
