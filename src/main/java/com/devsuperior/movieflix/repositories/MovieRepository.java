package com.devsuperior.movieflix.repositories;

import com.devsuperior.movieflix.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovieRepository extends JpaRepository<Movie, Long> {


    @Query("SELECT obj FROM Movie obj WHERE obj.genre.id = :genreId")
    Page<Movie> findByGenre(String genreId, Pageable pageable);

    /*@Query(nativeQuery = true, value = """
            SELECT TB_MOVIE.*, TB_GENRE.id
            FROM TB_MOVIE
            INNER JOIN TB_GENRE ON TB_MOVIE.genre_id = TB_GENRE.id
            WHERE TB_GENRE.id = :genreId
            """)
    Page<Movie> findByGenre(String genreId, Pageable pageable);
*/
}
