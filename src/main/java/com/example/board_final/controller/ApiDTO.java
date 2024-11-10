package com.example.board_final.controller;

import lombok.Data;

import java.util.List;

@Data
public class ApiDTO {
    private int currentCount;
    private List<ItemDTO> data;
}
