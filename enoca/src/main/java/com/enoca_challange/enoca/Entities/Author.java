package com.enoca_challange.enoca.Entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder



@Entity
public class Author {

   @Id
   @GeneratedValue(strategy =  GenerationType.AUTO)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL , orphanRemoval = true)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;








}
