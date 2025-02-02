package dev.rajnish.SplitWise.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="SplitWise-User")
public class User extends BaseModel {

    private String name;
    private String email;
    private String password;
    @ManyToMany
    private List<Group> groups;
    @ManyToMany
    private List<User> friends;    
}
