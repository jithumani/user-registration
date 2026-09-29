package com.example.userregistration.service;

import com.example.userregistration.model.User;
import com.example.userregistration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public User createUser(User user) {
        // TODO: Add email validation
        // TODO: Add username validation
        // TODO: Check for duplicate username/email before saving
        
        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        
        return userRepository.save(user);
    }
    
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
    
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    public List<User> getAllUsers() {
        // TODO: Add pagination
        // TODO: Add filtering capabilities
        return userRepository.findAll();
    }
    
    public User updateUser(Long id, User userDetails) {
        // TODO: Add proper error handling if user not found
        User user = userRepository.findById(id).orElse(null);
        
        if (user != null) {
            user.setUsername(userDetails.getUsername());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            return userRepository.save(user);
        }
        
        return null;
    }
    
    public boolean deleteUser(Long id) {
        // TODO: Add soft delete instead of hard delete
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    // TODO: Add method to deactivate user instead of deleting
    // TODO: Add password reset functionality
    // TODO: Add email verification process
}
