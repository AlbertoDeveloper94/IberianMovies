package com.videoclub.IberianMovies.model;

import jakarta.persistence.*;

@Entity
@Table(name = "iberian_movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int year;
    private int duration;

    private double rating;

    private String title;
    private String gender;
    private String director;
    private String description;

    public Movie() {

    }

    public Movie(int id, int year, int duration, double rating, String title, String gender, String director, String description) {
        this.id = id;
        this.year = year;
        this.duration = duration;
        this.rating = rating;
        this.title = title;
        this.gender = gender;
        this.director = director;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}