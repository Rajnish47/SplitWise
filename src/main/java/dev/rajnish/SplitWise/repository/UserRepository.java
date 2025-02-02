package dev.rajnish.SplitWise.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.rajnish.SplitWise.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

    public User getUserByEmail(String emaail);    
}
