package dev.rajnish.SplitWise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.rajnish.SplitWise.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
    
}
