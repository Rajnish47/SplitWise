package dev.rajnish.SplitWise.model;

import java.time.LocalDateTime;
import java.util.Currency;
import java.util.List;

import dev.rajnish.SplitWise.model.constants.SplitStratergy;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Expense extends BaseModel {

    private String description;
    private Currency currency;
    private double amount;
    private LocalDateTime expenseTime;
    private SplitStratergy splitStratergy;
    @ManyToOne
    private User addedBy;
    @OneToMany
    private List<UserExpense> userExpenses;
}
