package com.enoca_challange.enoca.Dto;

import com.enoca_challange.enoca.Entities.Author;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CreateBookRequest {

    private String name;
    private String authorName;
    private Double price;
    private Integer stock;

    private Author author;

}
