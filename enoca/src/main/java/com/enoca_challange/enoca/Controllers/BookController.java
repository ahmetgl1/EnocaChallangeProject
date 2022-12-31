package com.enoca_challange.enoca.Controllers;

import com.enoca_challange.enoca.Dto.BookDto;
import com.enoca_challange.enoca.Dto.CreateBookRequest;
import com.enoca_challange.enoca.Dto.UpdateBookRequest;
import com.enoca_challange.enoca.Entities.Book;
import com.enoca_challange.enoca.Services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/create")
    public ResponseEntity<BookDto> createBook(@RequestBody CreateBookRequest createBookRequest){

        return ResponseEntity.ok(bookService.createBook(createBookRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id){

        bookService.deleteBook(id);
        return ResponseEntity.ok().build();

    }


    @GetMapping("/{id}")
  public ResponseEntity<Optional<Book>> bookFindById(@PathVariable Integer id){

        return ResponseEntity.ok(bookService.findBookById(id));
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<BookDto>> bookGetAll(){

        return ResponseEntity.ok(bookService.bookGetAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDto> updateBookById(@PathVariable Integer id , @RequestBody UpdateBookRequest updateBookRequest){

        return ResponseEntity.ok(bookService.updateBook(id,updateBookRequest));
    }








}
