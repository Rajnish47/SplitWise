package dev.rajnish.SplitWise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.rajnish.SplitWise.dto.UserLoginRequestDTO;
import dev.rajnish.SplitWise.dto.UserSignUpRequestDTO;
import dev.rajnish.SplitWise.exception.InvalidDetailsException;
import dev.rajnish.SplitWise.mapper.DTOtoEntityMapper;
import dev.rajnish.SplitWise.mapper.EntityToDTOMapper;
import dev.rajnish.SplitWise.model.User;
import dev.rajnish.SplitWise.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private void validateEmail(String email)
    {
        if(email==null || email.isEmpty() || email.isBlank())
        {
            throw new InvalidDetailsException("Email is invalid");
        }
    }

    private void validatePassword(String passowrd)
    {
        if(passowrd==null || passowrd.isEmpty() || passowrd.isBlank())
        {
            throw new InvalidDetailsException("Password is invalid");
        }        
    }

    private void validateName(String name)
    {
        if(name==null || name.isEmpty() || name.isBlank())
        {
            throw new InvalidDetailsException("Name is invalid");
        }
    }

    @PostMapping("/user/signup")
    public ResponseEntity userSignUp(@RequestBody UserSignUpRequestDTO userSignUpRequestDTO)
    {
        User user = DTOtoEntityMapper.userDTOToEntity(userSignUpRequestDTO);
        validateEmail(user.getEmail());
        validateName(user.getName());
        validatePassword(user.getPassword());
        userService.userSignUp(user);

        return ResponseEntity.ok("SignUp is successful");
    }

    @GetMapping("/user/login")
    public ResponseEntity userLogin(@RequestBody UserLoginRequestDTO userLoginRequestDTO)
    {
        validateEmail(userLoginRequestDTO.getEmail());
        validatePassword(userLoginRequestDTO.getPassword());
        User user = userService.userLogin(userLoginRequestDTO.getEmail(),userLoginRequestDTO.getPassword());

        return ResponseEntity.ok(EntityToDTOMapper.userEntityToDTO(user));
    }    
}
