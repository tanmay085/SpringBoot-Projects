package com.tanmay.movieTicket.repository;

import com.tanmay.movieTicket.model.City;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

@Registered
public interface CityRepository extends JpaRepository<City,Long> {
}
