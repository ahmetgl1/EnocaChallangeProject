package com.enoca_challange.enoca.Repositories;

import com.enoca_challange.enoca.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
