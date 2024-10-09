package org.movie.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.movie.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class RegistrationServiceTest {
    private RegistrationService registrationService;
    private Map<String, User> users;
    private Scanner mockScanner;

    @BeforeEach
    public void setUp() {
        users = new HashMap<>();
        mockScanner = Mockito.mock(Scanner.class);
        registrationService = new RegistrationService(mockScanner);
    }

    @Test
    public void testRegister_SuccessfulRegistration() {
        when(mockScanner.nextLine()).thenReturn("user@example.com");
        registrationService.register(users);
        assertTrue(users.containsKey("user@example.com"));
    }

    @Test
    public void testRegister_UserAlreadyRegistered() {
        users.put("user@example.com", new User("user@example.com"));
        when(mockScanner.nextLine()).thenReturn("user@example.com");
        registrationService.register(users);
        assertEquals(1, users.size());
    }
}
