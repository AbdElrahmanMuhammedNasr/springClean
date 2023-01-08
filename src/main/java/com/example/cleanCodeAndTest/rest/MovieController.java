package com.example.cleanCodeAndTest.rest;

import com.example.cleanCodeAndTest.domain.Movie;
import com.example.cleanCodeAndTest.domain.dto.MovieDto;
import com.example.cleanCodeAndTest.service.interfaces.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(value = "/get-one-movie-id/{id}")
    public ResponseEntity<Object> getOneMovieId(@PathVariable(name = "id") Long id){
        Movie oneMovieUsingId = movieService.getOneMovieUsingId(id);
        return ResponseEntity
            .ok()
            .body(oneMovieUsingId);
    }
    @GetMapping(value = "/get-one-movie-name/{name}")
    public ResponseEntity<Object> getOneMovieName(@PathVariable(name = "name") String name){
        Movie movieUsingName = movieService.getOneMovieUsingName(name);
        return ResponseEntity
            .ok()
            .body(movieUsingName);
    }

    @GetMapping(value = "/get-one-movie-id-optional/{id}/{name}")
    public ResponseEntity<Object> getOneMovieIdOptional(@PathVariable(name = "id") Long id,
                                                        @PathVariable(name = "name") String name){
        Movie movieUsingName = movieService.getOneOptionalMovie(id,name);
        return ResponseEntity
            .ok()
            .body(movieUsingName);
    }

    @GetMapping(value = "/get-all-movies")
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> movies = movieService.getAllMovies();
        return ResponseEntity
            .ok()
            .body(movies);
    }

    @GetMapping(value = "/get-all-movies-dto")
    public ResponseEntity<List<MovieDto>> getAllMoviesDto(){
        List<MovieDto> movies = movieService.getAllMoviesDto();
        return ResponseEntity
            .ok()
            .body(movies);
    }
}
