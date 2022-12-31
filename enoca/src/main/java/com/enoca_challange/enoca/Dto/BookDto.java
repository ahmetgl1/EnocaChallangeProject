package com.enoca_challange.enoca.Dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Data
public class BookDto {

    private Integer id;
    private String name;
    private String authorName;
    private Double price;
    private Integer stock;
}
