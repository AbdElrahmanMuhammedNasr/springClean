package com.example.cleanCodeAndTest.repository;

import com.example.cleanCodeAndTest.domain.Movie;
import com.example.cleanCodeAndTest.domain.dto.MovieDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
    @Query("select m from Movie m where m.name = ?1")
    Movie findByName(String name);

    @Query("select m from Movie m where m.id = ?1 and m.name = ?2")
    Optional<Movie> findByIdAndName(Long id, String name);


}
