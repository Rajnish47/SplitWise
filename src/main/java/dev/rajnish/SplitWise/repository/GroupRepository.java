package dev.rajnish.SplitWise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.rajnish.SplitWise.model.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group,Integer> {
    
}
