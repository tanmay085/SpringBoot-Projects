package com.app.foodDelivery.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    @NotBlank(message = "userName should not be blank")
    private String name;
    @NotBlank(message = "Email should not be blank")
    private String email;
    @NotBlank(message = "Address should not be blank")
    private String address;
    @NotBlank(message = "Password should not be blank")
    private String password;
}
