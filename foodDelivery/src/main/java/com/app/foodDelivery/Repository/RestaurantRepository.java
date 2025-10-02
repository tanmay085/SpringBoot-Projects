package com.app.foodDelivery.Repository;

import com.app.foodDelivery.Entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository< Restaurant,Long> {
    public List<Restaurant> findAll();
}
