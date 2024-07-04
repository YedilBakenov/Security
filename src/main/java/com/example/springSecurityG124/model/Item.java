package com.example.springSecurityG124.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "items")
public class Item {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", columnDefinition = "text")
    private String name;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "price")
    private int price;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    public void createdAt(){
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void updatedAt(){
        updatedAt = LocalDateTime.now();
    }

}
