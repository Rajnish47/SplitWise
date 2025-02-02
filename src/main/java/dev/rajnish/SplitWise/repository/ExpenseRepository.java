package dev.rajnish.SplitWise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.rajnish.SplitWise.model.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Integer> {
    
}
