package org.movie.model;

import java.time.LocalDate;

public class Movie {
    private String title;
    private String cast;
    private String category;
    private LocalDate releaseDate;
    private double budget;

    public Movie(String title, String cast, String category, LocalDate releaseDate, double budget) {
        this.title = title;
        this.cast = cast;
        this.category = category;
        this.releaseDate = releaseDate;
        this.budget = budget;
    }

    public String getTitle() {
        return title;
    }

    public String getCast() {
        return cast;
    }

    public String getCategory() {
        return category;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public double getBudget() {
        return budget;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nCast: " + cast + "\nCategory: " + category + "\nRelease Date: " + releaseDate
                + "\nBudget: $" + budget + "\n";
    }
}
