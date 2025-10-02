package com.app.foodDelivery.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryDto {
    @NotBlank(message = "delivery status can't be blank")
    private String deliveryStatus;
    @NotBlank(message = "delivery address can't be blank")
    private String deliveryAddress;
    @NotBlank(message = "person name can't be blank")
    private String deliveryPerson;
}
