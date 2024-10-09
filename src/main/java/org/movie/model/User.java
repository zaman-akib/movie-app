package org.movie.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String email;
    private List<Movie> favoriteMovies = new ArrayList<>();

    public User(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public List<Movie> getFavoriteMovies() {
        return favoriteMovies;
    }

    public void addFavorite(Movie movie) {
        if (!favoriteMovies.contains(movie)) {
            favoriteMovies.add(movie);
            System.out.println("Added to favorites: " + movie.getTitle());
        } else {
            System.out.println("This movie is already in your favorite list.");
        }
    }

    public void removeFavorite(Movie movie) {
        if (favoriteMovies.remove(movie)) {
            System.out.println("Removed from favorites: " + movie.getTitle());
        } else {
            System.out.println("Movie not found in favorites.");
        }
    }
}
