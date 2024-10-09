package org.movie.service;

import org.movie.model.Movie;
import org.movie.model.User;

import java.util.*;

public class UserService {
    private final Scanner scanner;

    public UserService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void viewPersonalDetailsAndFavorites(User loggedInUser) {
        System.out.println("Email: " + loggedInUser.getEmail());
        System.out.println("--- Favorite Movies ---");
        loggedInUser.getFavoriteMovies().forEach(System.out::println);
    }

    public void searchFavoriteMovies(User loggedInUser) {
        System.out.println("Search in your favorites by title, cast, or category:");
        String query = scanner.nextLine().toLowerCase();

        loggedInUser.getFavoriteMovies().stream()
                .filter(movie -> movie.getTitle().toLowerCase().contains(query) ||
                        movie.getCast().toLowerCase().contains(query) ||
                        movie.getCategory().toLowerCase().contains(query))
                .sorted(Comparator.comparing(Movie::getTitle))
                .forEach(System.out::println);
    }

    public void addMovieToFavorites(List<Movie> movies, User loggedInUser) {
        MovieService movieService = new MovieService(scanner);
        movieService.showMovieList(movies);

        System.out.println("Enter the title of the movie to add to favorites:");
        String title = scanner.nextLine().toLowerCase();

        movies.stream()
                .filter(movie -> movie.getTitle().toLowerCase().equals(title))
                .findFirst()
                .ifPresentOrElse(loggedInUser::addFavorite,
                        () -> System.out.println("Movie not found."));
    }

    public void removeMovieFromFavorites(User loggedInUser) {
        System.out.println("Enter the title of the movie to remove from favorites:");
        String title = scanner.nextLine().toLowerCase();

        loggedInUser.getFavoriteMovies().stream()
                .filter(movie -> movie.getTitle().toLowerCase().equals(title))
                .findFirst()
                .ifPresentOrElse(loggedInUser::removeFavorite,
                        () -> System.out.println("Movie not found in favorites."));
    }
}
