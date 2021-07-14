package ru.myproj.gateway.model.dto;

import lombok.Data;

import java.math.BigInteger;

@Data
public class NoteDTO {
    private BigInteger id;
    private String body;
    private BigInteger userId;
}
