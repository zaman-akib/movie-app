package org.movie.sevice;

import org.movie.model.User;

import java.util.Map;
import java.util.Scanner;

public class LoginService {
    private final Scanner scanner;

    public LoginService(Scanner scanner) {
        this.scanner = scanner;
    }

    public User login(Map<String, User> users) {
        System.out.println("Enter your email:");
        String email = scanner.nextLine();
        User loggedInUser = null;

        if (users.containsKey(email)) {
            loggedInUser = users.get(email);
            System.out.println("Login successful!");
        } else {
            System.out.println("User not found. Please register first.");
        }

        return loggedInUser;
    }
}
