package com.app.foodDelivery.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {

    @NotBlank(message = "order status can't be blank")
    private String orderStatus;
    @NotNull(message = "price can't be blank")
    private Double totalPrice;
}
