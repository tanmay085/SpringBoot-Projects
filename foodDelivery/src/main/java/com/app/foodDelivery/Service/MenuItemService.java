package com.app.foodDelivery.Service;

import com.app.foodDelivery.Dto.MenuItemDto;
import com.app.foodDelivery.Entity.MenuItem;
import com.app.foodDelivery.Entity.Restaurant;
import com.app.foodDelivery.Exception.MenuNotFound;
import com.app.foodDelivery.Exception.RestaurantNotFound;
import com.app.foodDelivery.Repository.MenuItemRepository;
import com.app.foodDelivery.Repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuItemService {
    @Autowired
    private MenuItemRepository menuItemRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public MenuItemDto addMenuItem(Long id,MenuItemDto menuItemDto ){
        MenuItem menuItem=new MenuItem();
        Restaurant restaurant=restaurantRepository.findById(id).
                orElseThrow(()-> new RestaurantNotFound("Restaurant Not found by id: "+id));
        menuItem.setRestaurant(restaurant);
        menuItem.setName(menuItemDto.getName());
        menuItem.setPrice(menuItemDto.getPrice());
        menuItemRepository.save(menuItem);
        return menuItemDto;
    }

    public void deleteMenuItem(Long id){
        MenuItem menuItem=menuItemRepository.findById(id).
                orElseThrow(()->new MenuNotFound("Menu item not found by id: "+id));
        menuItemRepository.delete(menuItem);
    }
}
