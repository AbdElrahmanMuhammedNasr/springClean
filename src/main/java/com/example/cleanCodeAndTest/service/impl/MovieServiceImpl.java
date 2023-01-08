package com.example.cleanCodeAndTest.service.impl;

import com.example.cleanCodeAndTest.domain.Movie;
import com.example.cleanCodeAndTest.domain.dto.MovieDto;
import com.example.cleanCodeAndTest.domain.enumeration.ErrorCode;
import com.example.cleanCodeAndTest.exceptions.BusinessException;
import com.example.cleanCodeAndTest.repository.MovieRepository;
import com.example.cleanCodeAndTest.service.interfaces.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    private ModelMapper modelMapper;
    private Random random = new Random();
    public MovieServiceImpl(MovieRepository movieRepository, ModelMapper modelMapper) {
        this.movieRepository = movieRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Movie getOneMovieUsingId(Long id) {
        return movieRepository.findById(id)
            .orElseThrow(()-> new BusinessException("Id Not Found",ErrorCode.NOT_FOUND));
    }

    @Override
    public Movie getOneMovieUsingName(String name) {
        Movie movie = movieRepository.findByName(name);
        if (movie == null)
            throw new BusinessException("Movie not Found", ErrorCode.NOT_FOUND);
        return  movie;
    }

    @Override
    public Movie getOneOptionalMovie(Long id,String name) {
      return  movieRepository.findByIdAndName(id, name)
                .map(this::appendName)
                .map(movie -> {
                    movie.setName(movie.getName().toUpperCase());
                    return movie;
                })
                .orElseThrow( () -> new BusinessException("Movie Not Found",ErrorCode.NOT_FOUND));


    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getId() % 2 ==0 )
                .map(this::appendName)
                .map(this::changeAge)
                .filter(movie -> movie.getAge() < 10)
                .collect(Collectors.toList())
            ;

    }

    @Override
    public List<MovieDto> getAllMoviesDto() {
        return movieRepository.findAll()
            .stream()
            .map(this::changeAge)
            .filter(movie -> movie.getAge() < 10)
            .sorted(Comparator.comparing(Movie::getAge).reversed())
            .map(movie -> modelMapper.map(movie,MovieDto.class))
            .collect(Collectors.toList());
    }

    private Movie appendName(Movie movie){
        movie.setName("appended "+movie.getName()+" appended");
        return movie;
    }

    private Movie changeAge(Movie movie){
        movie.setAge(random.nextInt(100));
        return movie;
    }
}
