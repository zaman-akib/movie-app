package org.movie.service;

import org.movie.model.Movie;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MovieService {
    private final Scanner scanner;

    public MovieService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void searchMovies(List<Movie> movies) {
        System.out.println("Search by title, cast, or category:");
        String query = scanner.nextLine().toLowerCase();

        movies.stream()
                .filter(movie -> movie.getTitle().toLowerCase().contains(query) ||
                        movie.getCast().toLowerCase().contains(query) ||
                        movie.getCategory().toLowerCase().contains(query))
                .sorted(Comparator.comparing(Movie::getTitle))
                .forEach(System.out::println);
    }

    public void viewMovieDetails(List<Movie> movies) {
        showMovieList(movies);

        System.out.println("Enter the title of the movie:");
        String title = scanner.nextLine().toLowerCase();

        movies.stream()
                .filter(movie -> movie.getTitle().toLowerCase().equals(title))
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("Movie not found."));
    }

    public void initializeMovies(List<Movie> movies) {
        movies.add(new Movie("Inception", "Leonardo DiCaprio", "Sci-Fi", LocalDate.of(2010, 7, 16), 160000000));
        movies.add(new Movie("The Dark Knight", "Christian Bale", "Action", LocalDate.of(2008, 7, 18), 185000000));
        movies.add(new Movie("Interstellar", "Matthew McConaughey", "Sci-Fi", LocalDate.of(2014, 11, 7), 165000000));
        movies.add(new Movie("The Matrix", "Keanu Reeves", "Sci-Fi", LocalDate.of(1999, 3, 31), 63000000));
        movies.add(new Movie("Pulp Fiction", "John Travolta", "Crime", LocalDate.of(1994, 10, 14), 8000000));
    }

    public void showMovieList(List<Movie> movies) {
        System.out.println("--- List of All Movies---");
        for (Movie movie : movies) {
            System.out.println(movie.getTitle());
        }
    }
}
