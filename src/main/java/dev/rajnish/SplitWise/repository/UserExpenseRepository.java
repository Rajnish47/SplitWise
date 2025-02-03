package dev.rajnish.SplitWise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.rajnish.SplitWise.model.UserExpense;

@Repository
public interface UserExpenseRepository extends JpaRepository<UserExpense,Integer> {
    
}
