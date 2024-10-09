package org.movie;

import org.movie.model.Movie;
import org.movie.model.User;
import org.movie.service.LoginService;
import org.movie.service.MovieService;
import org.movie.service.RegistrationService;
import org.movie.service.UserService;

import java.util.*;

public class MovieApp {
    private static List<Movie> movies = new ArrayList<>();
    private static Map<String, User> users = new HashMap<>();
    private static User loggedInUser;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MovieService movieService = new MovieService(scanner);
        movieService.initializeMovies(movies);

        System.out.println("Welcome to Movie App!");

        while (true) {
            if (loggedInUser == null) {
                showLoginOrRegisterMenu();
            } else {
                System.out.println("\nMain Menu:");
                showMainMenu();
            }
        }
    }

    private static void showLoginOrRegisterMenu() {
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.println("Enter your choice:");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                RegistrationService registrationService = new RegistrationService(scanner);
                registrationService.register(users);
                showLoginOrRegisterMenu();
                break;
            case 2:
                LoginService loginService = new LoginService(scanner);
                loggedInUser = loginService.login(users);
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice.");
                showLoginOrRegisterMenu();
        }
    }

    private static void showMainMenu() {
        System.out.println("1. Search all movies");
        System.out.println("2. View movie details");
        System.out.println("3. Add movie to favorites");
        System.out.println("4. Remove movie from favorites");
        System.out.println("5. View personal details and favorites");
        System.out.println("6. Search favorite movies");
        System.out.println("7. Logout");
        System.out.println("Enter your choice:");
        int choice = scanner.nextInt();
        scanner.nextLine();

        MovieService movieService = new MovieService(scanner);
        UserService userService = new UserService(scanner);

        switch (choice) {
            case 1:
                movieService.searchMovies(movies);
                break;
            case 2:
                movieService.viewMovieDetails(movies);
                break;
            case 3:
                userService.addMovieToFavorites(movies, loggedInUser);
                break;
            case 4:
                userService.removeMovieFromFavorites(loggedInUser);
                break;
            case 5:
                userService.viewPersonalDetailsAndFavorites(loggedInUser);
                break;
            case 6:
                userService.searchFavoriteMovies(loggedInUser);
                break;
            case 7:
                loggedInUser = null;
                System.out.println("Logged out.");
                break;
            default:
                System.out.println("Invalid choice.");
                showMainMenu();
        }
    }
}