package com.app.foodDelivery.Service;


import com.app.foodDelivery.Dto.MenuItemDto;
import com.app.foodDelivery.Dto.OrderDto;
import com.app.foodDelivery.Dto.UserDto;
import com.app.foodDelivery.Entity.MenuItem;
import com.app.foodDelivery.Entity.Order;
import com.app.foodDelivery.Entity.OrderDetail;
import com.app.foodDelivery.Entity.User;
import com.app.foodDelivery.Exception.MenuNotFound;
import com.app.foodDelivery.Exception.UserNotFound;
import com.app.foodDelivery.Repository.MenuItemRepository;
import com.app.foodDelivery.Repository.OrderRepository;
import com.app.foodDelivery.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MenuItemRepository menuItemRepository;
    @Autowired
    private OrderRepository orderRepository;


    public UserDto createUser(UserDto userDto){
        User user =new User();
        user.setName(userDto.getName());
        user.setAddress(userDto.getAddress());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        userRepository.save(user);
        return userDto;

    }

    public Order placeOrder(Long id, List<Long> itemIds){

        User user =userRepository.findById(id).
                orElseThrow(()-> new UserNotFound("User not found by id: "+id));
        Order order =new Order();
        OrderDto orderDto=new OrderDto();
        order.setUser(user);
        order.setOrderStatus("pending");

        List<OrderDetail> orderDetails=new ArrayList<>();
        double total=0;
        for(Long itemId:itemIds){

            MenuItem item= menuItemRepository.findById(itemId).
                    orElseThrow(()-> new MenuNotFound("item not found by id: "+id));
            OrderDetail orderDetail=new OrderDetail();
            orderDetail.setMenuItem(item);
            orderDetail.setQuantity(1);
            orderDetail.setPrice(item.getPrice());
            orderDetail.setOrder(order);
            total+=item.getPrice();
            orderDetails.add(orderDetail);
        }
        order.setOrderDetails(orderDetails);
        order.setTotalAmount(total);

        return orderRepository.save(order);

    }

}
