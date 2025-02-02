package dev.rajnish.SplitWise.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="Splitwise-Group")
public class Group extends BaseModel {

    private String name;
    private String description;
    @ManyToMany
    private List<User> groupMembers;
    @OneToMany
    private List<Expense> expenses;
    @OneToMany
    private List<Transaction> transactions;
}
