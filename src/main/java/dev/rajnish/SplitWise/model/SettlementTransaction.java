package dev.rajnish.SplitWise.model;

import java.util.Currency;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SettlementTransaction extends BaseModel {

    @ManyToOne
    private User lender;
    @ManyToOne
    private User borrower;
    private double amount;
    private Currency currency;   
}
