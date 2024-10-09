package org.movie.service;

import org.movie.model.User;

import java.util.Map;
import java.util.Scanner;

public class RegistrationService {
    private final Scanner scanner;

    public RegistrationService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void register(Map<String, User> users) {
        System.out.println("Enter your email:");
        String email = scanner.nextLine();

        if (users.containsKey(email)) {
            System.out.println("User already registered.");
        } else {
            users.put(email, new User(email));
            System.out.println("Registration successful!");
        }
    }
}
