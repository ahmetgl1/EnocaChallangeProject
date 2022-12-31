package com.enoca_challange.enoca.Dto;

import com.enoca_challange.enoca.Entities.Book;
import org.springframework.stereotype.Component;

@Component
public class BookDtoConverter {

    public BookDto convert(Book book){

        BookDto bookDto = new BookDto();

        bookDto.setName(book.getName());
        bookDto.setPrice(book.getPrice());
        bookDto.setAuthorName(book.getAuthorName());
        bookDto.setStock(book.getStock());

        return bookDto;

    }


}
