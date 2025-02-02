package dev.rajnish.SplitWise.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Transaction extends BaseModel {

    private double amount;
    @ManyToMany
    private List<User> parties; // index 0-lender, index 1-borrower 
    @ManyToOne
    private Group group;    
}
