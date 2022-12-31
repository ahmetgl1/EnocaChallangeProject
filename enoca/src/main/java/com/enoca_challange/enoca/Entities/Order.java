package com.enoca_challange.enoca.Entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity(name = "book_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String userName;
    @ElementCollection(targetClass = Integer.class)
    private List<Integer> bookList = new ArrayList<>();
    private Double totalPrice;

}
