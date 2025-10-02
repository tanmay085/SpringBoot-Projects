package com.app.foodDelivery.Controller;

import com.app.foodDelivery.Dto.MenuItemDto;
import com.app.foodDelivery.Dto.OrderDto;
import com.app.foodDelivery.Dto.RestaurantDto;
import com.app.foodDelivery.Entity.MenuItem;
import com.app.foodDelivery.Entity.Restaurant;
import com.app.foodDelivery.Service.MenuItemService;
import com.app.foodDelivery.Service.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Admin {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private MenuItemService menuItemService;

    @PostMapping("/restaurant")
    public ResponseEntity<RestaurantDto> createRestaurant(@Valid @RequestBody RestaurantDto restaurantDto){
        return  ResponseEntity.ok(restaurantService.createRestaurant(restaurantDto));
    }

    @GetMapping("/getRestaurant")
    public ResponseEntity<List<Restaurant>> getAllRestaurant(){
        return ResponseEntity.ok(restaurantService.getAllRestaurant());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void>deleteRestaurant(@PathVariable Long id){
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/menuItem/{id}")
    public ResponseEntity<MenuItemDto>addMenuItem(@Valid@PathVariable Long id, @RequestBody MenuItemDto menuItemDto){
        return ResponseEntity.ok(menuItemService.addMenuItem(id, menuItemDto));
    }

    @DeleteMapping("/deleteMenu/{id}")
    public ResponseEntity<Void> deleteMenuItem(@PathVariable Long id){
        menuItemService.deleteMenuItem(id);
        return ResponseEntity.noContent().build();
    }



    


}
