package com.jackson.repository;

import com.jackson.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieCinemaRepository extends JpaRepository<MovieCinema,Long> {

    // ------------------- DERIVED QUERIES ------------------- //
//Write a derived query to read movie cinema with id

    Optional<MovieCinema> findById(Long id);

//Write a derived query to count all movie cinemas with a specific cinema id

    Integer countAllByCinemaId(long id);

//Write a derived query to count all movie cinemas with a specific movie id

    Integer countAllByMovieId(long id);

//Write a derived query to list all movie cinemas with higher than a specific date
    List<MovieCinema> findAllByDateTimeAfter(LocalDate date);


//Write a derived query to find the top 3 expensive movies

    List<MovieCinema> findFirst3ByOrderByMoviePrice();


    //Write a derived query to list all movie cinemas that contain a specific movie name
    List<MovieCinema> findAllByMovieNameContaining(String name);


    //Write a derived query to list all movie cinemas in a specific location
    List<MovieCinema> findAllByCinemaLocationName(String name);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movie cinemas with after a specific date

    @Query("SELECT mc FROM MovieCinema mc WHERE mc.dateTime > ?1")
    List<MovieCinema> fetchAllWithHigherSpecificDateJPQL(LocalDateTime dateTime);




// ------------------- Native QUERIES ------------------- //
//Write a native query to count all movie cinemas by cinema id

    @Query(value = "SELECT count(*) FROM movie_cinema where cinema_id= ?1"
            ,nativeQuery = true)
    Integer countAllMovieByCinemaId(long id);


//Write a native query that returns all movie cinemas by location name

    @Query(value = "SELECT * FROM movie_cinema m join location l on l.id=m.cinema_id where l.name= ?1"
            ,nativeQuery = true)
    List<MovieCinema> fetchAllByLocationName(String locationName);


}
