package ru.myproj.gateway.model.dto;

import lombok.Data;

import java.math.BigInteger;

@Data
public class UserDTO {
    protected BigInteger id;
    protected String username;
    protected String password;

}
