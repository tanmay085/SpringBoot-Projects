package com.app.foodDelivery.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class RestaurantDto {

    @NotBlank(message = "Name should not be blank")
    private String name;

    @NotBlank(message = "Address should not be blank")
    private String address;

    @NotBlank(message = "Phone number should not be blank")
    private String phone;


}
