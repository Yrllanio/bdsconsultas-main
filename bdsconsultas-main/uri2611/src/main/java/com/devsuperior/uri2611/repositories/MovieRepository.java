package com.devsuperior.uri2611.repositories;

import com.devsuperior.uri2611.dto.MovieNameDTO;
import com.devsuperior.uri2611.entities.Movie;
import com.devsuperior.uri2611.projections.MovieNameProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(nativeQuery = true, value = "select m.id , m.name  from movies m inner join genres g on m.id_genres = g.id where g.description =:description")
    List<MovieNameProjection> search1(String description);

    @Query("SELECT new com.devsuperior.uri2611.dto.MovieNameDTO(m.id, m.name) FROM Movie m WHERE m.genre.description =:description")
    List<MovieNameDTO> search2(String description);
}
