package com.tanmay.movieTicket.repository;

import com.tanmay.movieTicket.model.City;
import com.tanmay.movieTicket.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheaterRepository extends JpaRepository<Theater,Long> {

    public List<Theater> findByCity(City city);
}
