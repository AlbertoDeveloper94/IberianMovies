package com.videoclub.IberianMovies.service;

import com.videoclub.IberianMovies.model.Movie;
import com.videoclub.IberianMovies.repository.MovieRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository repository) {
        this.movieRepository = repository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public void saveMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public void deleteMovie(int id) {
        movieRepository.deleteById(id);
    }

    public List<Movie> getAllByOrder(){
        return movieRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    public Optional<Movie> getMovieById(int id){
        return movieRepository.findById(id);
    }
    public Movie updateMovie(int id, Movie updatedMovie){

        Optional<Movie> foundMovie = movieRepository.findById(id);

        if(foundMovie.isPresent()){
            Movie existingMovie = foundMovie.get();

            existingMovie.setTitle(updatedMovie.getTitle());
            existingMovie.setDescription(updatedMovie.getDescription());
            existingMovie.setYear(updatedMovie.getYear());
            existingMovie.setDuration(updatedMovie.getDuration());
            existingMovie.setRating(updatedMovie.getRating());
            existingMovie.setGender(updatedMovie.getGender());
            existingMovie.setDirector(updatedMovie.getDirector());

            return movieRepository.save(existingMovie);

        }

        throw new RuntimeException("Movie not found in DDBB with id : " + id);
    }


}
