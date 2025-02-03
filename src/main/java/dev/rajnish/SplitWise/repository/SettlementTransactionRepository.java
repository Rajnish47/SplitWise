package dev.rajnish.SplitWise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.rajnish.SplitWise.model.SettlementTransaction;

@Repository
public interface SettlementTransactionRepository extends JpaRepository<SettlementTransaction,Integer> {
    
}
