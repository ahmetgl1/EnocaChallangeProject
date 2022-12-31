package com.enoca_challange.enoca.Repositories;

import com.enoca_challange.enoca.Entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author , Integer> {
}
