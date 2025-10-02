package com.app.foodDelivery.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuItemDto {

    @NotBlank(message = "Name should not be blank")
    private String name;
    @NotNull(message = "price should not be null")
    private Double price;

}
