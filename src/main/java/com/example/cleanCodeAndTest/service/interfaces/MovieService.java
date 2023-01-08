package com.example.cleanCodeAndTest.service.interfaces;

import com.example.cleanCodeAndTest.domain.Movie;
import com.example.cleanCodeAndTest.domain.dto.MovieDto;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    Movie getOneMovieUsingId(Long id);
    Movie getOneMovieUsingName(String name);

    Movie getOneOptionalMovie(Long id,String name);

    List<Movie> getAllMovies();

    List<MovieDto> getAllMoviesDto();

}
