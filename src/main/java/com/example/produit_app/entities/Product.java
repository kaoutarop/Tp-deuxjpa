package com.example.produit_app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor @Getter @Setter @AllArgsConstructor @ToString
public class Product {
   @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
   private Long id;
   private String name;
   private double price;
   private int quantity;
}
