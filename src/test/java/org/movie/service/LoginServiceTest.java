package org.movie.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.movie.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class LoginServiceTest {
    private LoginService loginService;
    private Map<String, User> users;
    private Scanner mockScanner;

    @BeforeEach
    public void setUp() {
        mockScanner = Mockito.mock(Scanner.class);

        loginService = new LoginService(mockScanner);

        users = new HashMap<>();
        users.put("user1@example.com", new User("user1@example.com"));
        users.put("user2@example.com", new User("user2@example.com"));
    }

    @Test
    public void testLogin_SuccessfulLogin() {
        when(mockScanner.nextLine()).thenReturn("user1@example.com");

        User result = loginService.login(users);

        assertNotNull(result);
        assertEquals("user1@example.com", result.getEmail());
    }

    @Test
    public void testLogin_UserNotFound() {
        when(mockScanner.nextLine()).thenReturn("unknown@example.com");

        User result = loginService.login(users);

        assertNull(result);
    }

    @Test
    public void testLogin_NoUsers() {
        Map<String, User> emptyUsers = new HashMap<>();

        when(mockScanner.nextLine()).thenReturn("user1@example.com");

        User result = loginService.login(emptyUsers);

        assertNull(result);
    }
}
