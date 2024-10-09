package org.movie.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.movie.model.Movie;
import org.movie.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class UserServiceTest {
    private UserService userService;
    private List<Movie> movies;
    private User loggedInUser;
    private Scanner mockScanner;

    @BeforeEach
    public void setUp() {
        movies = new ArrayList<>();
        mockScanner = Mockito.mock(Scanner.class);
        userService = new UserService(mockScanner);
        loggedInUser = new User("user@example.com");
        movies.add(new Movie("Inception", "Leonardo DiCaprio", "Sci-Fi", LocalDate.of(2010, 7, 16), 160000000));
        movies.add(new Movie("The Dark Knight", "Christian Bale", "Action", LocalDate.of(2008, 7, 18), 185000000));
    }

    @Test
    public void testViewPersonalDetailsAndFavorites() {
        loggedInUser.addFavorite(movies.get(0));
        userService.viewPersonalDetailsAndFavorites(loggedInUser);
        assertEquals("user@example.com", loggedInUser.getEmail());
        assertTrue(loggedInUser.getFavoriteMovies().contains(movies.get(0)));
    }

    @Test
    public void testSearchFavoriteMovies_MovieFound() {
        loggedInUser.addFavorite(movies.get(0));
        when(mockScanner.nextLine()).thenReturn("Inception");
        userService.searchFavoriteMovies(loggedInUser);
        assertTrue(loggedInUser.getFavoriteMovies().stream().anyMatch(movie -> movie.getTitle().equals("Inception")));
    }

    @Test
    public void testSearchFavoriteMovies_NoMatch() {
        loggedInUser.addFavorite(movies.get(0));
        when(mockScanner.nextLine()).thenReturn("Unknown Movie");
        userService.searchFavoriteMovies(loggedInUser);
        assertFalse(loggedInUser.getFavoriteMovies().stream().anyMatch(movie -> movie.getTitle().equals("Unknown Movie")));
    }

    @Test
    public void testAddMovieToFavorites_MovieFound() {
        when(mockScanner.nextLine()).thenReturn("Inception");
        userService.addMovieToFavorites(movies, loggedInUser);
        assertTrue(loggedInUser.getFavoriteMovies().contains(movies.get(0)));
    }

    @Test
    public void testAddMovieToFavorites_MovieNotFound() {
        when(mockScanner.nextLine()).thenReturn("Unknown Movie");
        userService.addMovieToFavorites(movies, loggedInUser);
        assertFalse(loggedInUser.getFavoriteMovies().contains(movies.get(0)));
    }

    @Test
    public void testRemoveMovieFromFavorites_MovieFound() {
        loggedInUser.addFavorite(movies.get(0));
        when(mockScanner.nextLine()).thenReturn("Inception");
        userService.removeMovieFromFavorites(loggedInUser);
        assertFalse(loggedInUser.getFavoriteMovies().contains(movies.get(0)));
    }

    @Test
    public void testRemoveMovieFromFavorites_MovieNotFound() {
        when(mockScanner.nextLine()).thenReturn("Unknown Movie");
        userService.removeMovieFromFavorites(loggedInUser);
        assertTrue(loggedInUser.getFavoriteMovies().isEmpty());
    }
}
