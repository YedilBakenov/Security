package com.example.springSecurityG124.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class ItemDTO {

    private int id;

    private String itemName;

    private String description;

    private int price;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
