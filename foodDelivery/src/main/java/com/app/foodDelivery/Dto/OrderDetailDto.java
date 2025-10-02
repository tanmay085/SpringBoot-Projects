package com.app.foodDelivery.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailDto {
    @NotNull(message = "quantity can't be blank")
    private int quantity;
    @NotBlank(message = "price can't be blank")
    private Double price;

}
