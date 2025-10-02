package com.app.foodDelivery.Controller;

import com.app.foodDelivery.Dto.OrderDto;
import com.app.foodDelivery.Dto.UserDto;
import com.app.foodDelivery.Entity.MenuItem;
import com.app.foodDelivery.Entity.Order;
import com.app.foodDelivery.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class User {

    @Autowired
    private UserService userService;

    @PostMapping("/test")
    public void testing(){
        System.out.println("working");
    }

    @PostMapping("/createUser")
    public ResponseEntity<UserDto> createUser(@Valid@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.createUser(userDto));
    }

    @PostMapping("/{id}/order")
    public ResponseEntity<Order> placeOrder(@PathVariable Long id, @RequestBody List<Long> itemIds){
        return ResponseEntity.ok(userService.placeOrder(id, itemIds));
    }
}
