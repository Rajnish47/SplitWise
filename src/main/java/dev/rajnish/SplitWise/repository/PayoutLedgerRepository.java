package dev.rajnish.SplitWise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.rajnish.SplitWise.model.PayoutLedger;

@Repository
public interface PayoutLedgerRepository extends JpaRepository<PayoutLedger,Integer> {
    
}
