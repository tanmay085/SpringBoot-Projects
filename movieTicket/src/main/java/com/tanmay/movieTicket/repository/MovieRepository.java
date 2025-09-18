package com.tanmay.movieTicket.repository;

import com.tanmay.movieTicket.model.Movie;
import com.tanmay.movieTicket.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
    public List<Movie> findByTheater(Theater theater);
}
