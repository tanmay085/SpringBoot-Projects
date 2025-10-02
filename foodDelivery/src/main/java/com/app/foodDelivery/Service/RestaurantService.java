package com.app.foodDelivery.Service;

import com.app.foodDelivery.Dto.RestaurantDto;
import com.app.foodDelivery.Entity.Restaurant;
import com.app.foodDelivery.Exception.RestaurantNotFound;
import com.app.foodDelivery.Repository.RestaurantRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public RestaurantDto createRestaurant(RestaurantDto restaurantDto){
        Restaurant restaurant=new Restaurant();
        restaurant.setName(restaurantDto.getName());
        restaurant.setAddress(restaurantDto.getAddress());
        restaurant.setPhone(restaurantDto.getPhone());
        restaurantRepository.save(restaurant);
        return restaurantDto;
    }

    public List<Restaurant> getAllRestaurant(){
        return restaurantRepository.findAll();
    }

    public void deleteRestaurant(Long id){
        Restaurant restaurant=restaurantRepository.findById(id).
                orElseThrow(()-> new RestaurantNotFound("restaurant not for by id: "+id));
        restaurantRepository.delete(restaurant);
    }
}
