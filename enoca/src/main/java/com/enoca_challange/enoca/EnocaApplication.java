package com.enoca_challange.enoca;

import com.enoca_challange.enoca.Entities.Author;
import com.enoca_challange.enoca.Entities.Book;
import com.enoca_challange.enoca.Repositories.AuthorRepository;
import com.enoca_challange.enoca.Repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EnocaApplication implements CommandLineRunner {
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;

	public EnocaApplication(AuthorRepository authorRepository,
							BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(EnocaApplication.class, args);
		
		System.out.println("Hello World !");
	}

	@Override
	public void run(String... args) throws Exception {

		Book book1 = Book.builder()

				.name("IKIGAI")
				.stock(17)
				.price(49.90)
				.authorName("Hector Garcia")

				.build();

		Author author1 = Author.builder()
				.book(book1)

				.build();


		authorRepository.save(author1);
		bookRepository.save(book1);

	//
		//Book book2 = Book.builder()
//
		//		.name("Geleceğin Fiziği")
		//		.stock(24)
		//		.price(170.0)
		//		.authorName("MICHIOU KAKU")
		//		.author(author2)
		//		.author(author2)
		//		.build();






	}
}
