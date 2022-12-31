package com.enoca_challange.enoca.Entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder


@Entity(name ="book")
public class Book {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Integer id;
    private String name;
    private String authorName;
    private Double price;
    private Integer stock;

    @OneToOne(mappedBy = "book")
    private Author author;


}



