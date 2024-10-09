package org.movie.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.movie.model.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class MovieServiceTest {
    private MovieService movieService;
    private List<Movie> movies;
    private Scanner mockScanner;

    @BeforeEach
    public void setUp() {
        movies = new ArrayList<>();
        mockScanner = Mockito.mock(Scanner.class);
        movieService = new MovieService(mockScanner);
        movieService.initializeMovies(movies);
    }

    @Test
    public void testSearchMovies_TitleFound() {
        when(mockScanner.nextLine()).thenReturn("Inception");
        movieService.searchMovies(movies);
        assertEquals(1, movies.stream().filter(movie -> movie.getTitle().equals("Inception")).count());
    }

    @Test
    public void testSearchMovies_NoMatch() {
        when(mockScanner.nextLine()).thenReturn("Unknown Movie");
        movieService.searchMovies(movies);
        assertEquals(0, movies.stream().filter(movie -> movie.getTitle().equals("Unknown Movie")).count());
    }

    @Test
    public void testViewMovieDetails_MovieFound() {
        when(mockScanner.nextLine()).thenReturn("Inception");
        movieService.viewMovieDetails(movies);
        assertTrue(movies.stream().anyMatch(movie -> movie.getTitle().equals("Inception")));
    }

    @Test
    public void testViewMovieDetails_MovieNotFound() {
        when(mockScanner.nextLine()).thenReturn("Unknown Movie");
        movieService.viewMovieDetails(movies);
        assertFalse(movies.stream().anyMatch(movie -> movie.getTitle().equals("Unknown Movie")));
    }

    @Test
    public void testShowMovieList() {
        movieService.showMovieList(movies);
        assertEquals(5, movies.size());
    }
}
