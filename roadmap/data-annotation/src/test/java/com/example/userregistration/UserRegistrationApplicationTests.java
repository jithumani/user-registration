package com.example.userregistration;

import com.example.userregistration.model.User;
import com.example.userregistration.repository.UserRepository;
import com.example.userregistration.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRegistrationApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void contextLoads() {
        assertNotNull(userService);
        assertNotNull(userRepository);
    }

    @Test
    void testCreateUser() {
        User user = new User("testuser", "test@example.com", "password123");
        User createdUser = userService.createUser(user);
        
        assertNotNull(createdUser);
        assertNotNull(createdUser.getId());
        assertEquals("testuser", createdUser.getUsername());
    }

    @Test
    void testGetUserById() {
        User user = new User("getuser", "get@example.com", "password123");
        User createdUser = userService.createUser(user);
        
        var foundUser = userService.getUserById(createdUser.getId());
        assertTrue(foundUser.isPresent());
        assertEquals("getuser", foundUser.get().getUsername());
    }

    @Test
    void testGetAllUsers() {
        var users = userService.getAllUsers();
        assertNotNull(users);
        // TODO: Add assertion for expected count
    }

    @Test
    void testDeleteUser() {
        User user = new User("deleteuser", "delete@example.com", "password123");
        User createdUser = userService.createUser(user);
        
        boolean deleted = userService.deleteUser(createdUser.getId());
        assertTrue(deleted);
    }

    // TODO: Add test for updateUser
    // TODO: Add test for getUserByUsername
    // TODO: Add test for duplicate username handling
    // TODO: Add test for email validation
    // TODO: Add test for empty username handling
    // TODO: Add test for user deactivation
    // TODO: Add integration tests for controller endpoints
}
