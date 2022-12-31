package com.enoca_challange.enoca.Services;


import com.enoca_challange.enoca.Dto.BookDto;
import com.enoca_challange.enoca.Dto.BookDtoConverter;
import com.enoca_challange.enoca.Dto.CreateBookRequest;
import com.enoca_challange.enoca.Dto.UpdateBookRequest;
import com.enoca_challange.enoca.Entities.Book;
import com.enoca_challange.enoca.Repositories.BookRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

 private final BookRepository bookRepository;
 private final BookDtoConverter bookDtoConverter;



    public BookService(BookRepository bookRepository, BookDtoConverter bookDtoConverter) {
        this.bookRepository = bookRepository;
        this.bookDtoConverter = bookDtoConverter;
    }

  public Optional<Book> findBookById(Integer id){

  //    Optional<Book> optionalBook =
              return bookRepository.findById(id);


  }

    public BookDto createBook(CreateBookRequest createBookRequest){


        Book book = new Book();

        book.setName(createBookRequest.getName());
        book.setAuthorName(createBookRequest.getAuthorName());
        book.setPrice(createBookRequest.getPrice());
        book.setStock(createBookRequest.getStock());
        book.setAuthor(createBookRequest.getAuthor());

        bookRepository.save(book);

     return bookDtoConverter.convert(book);

    }

    public void deleteBook(Integer id) {

        Optional<Book> optionalCustomer = bookRepository.findById(id);
       optionalCustomer.map(customer -> bookRepository.findById(id));
    }


    public BookDto updateBook(Integer id , UpdateBookRequest updateBookRequest){

        Optional<Book> optionalBook = bookRepository.findById(id);
        optionalBook.ifPresent(book -> {


            book.setName(updateBookRequest.getName());
            book.setAuthorName(updateBookRequest.getAuthorName());
            book.setPrice(updateBookRequest.getPrice());
            book.setStock(updateBookRequest.getStock());
           book.setAuthor(updateBookRequest.getAuthor());


            bookRepository.save(book);

        });

        return optionalBook.map(bookDtoConverter::convert)
                .orElse(new BookDto());
    }

  //  public BookDto getBookById(Integer id){
//
  //      //exception fırlatılacak !
  //      return bookRepository.findById(id).orElse(new Book());
//
  //  }


    public List<BookDto> bookGetAll(){

        List<Book> bookList = bookRepository.findAll();

        List<BookDto> bookDtoList =   new ArrayList<>();

        for(Book book: bookList) {
            bookDtoList.add(bookDtoConverter.convert(book));
        }

        return bookDtoList;
    }








}
