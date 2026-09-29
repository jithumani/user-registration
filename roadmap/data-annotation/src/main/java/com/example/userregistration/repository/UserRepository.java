package com.example.userregistration.repository;

import com.example.userregistration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByUsername(String username);
    
    Optional<User> findByEmail(String email);
    
    // TODO: Add methods for finding active/inactive users
    // TODO: Add pagination support for user listing
}
