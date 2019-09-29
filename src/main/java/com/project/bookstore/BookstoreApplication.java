package com.project.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.project.bookstore.domain.*;

import com.project.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository catRepository) {
		return (args) -> {	
			catRepository.deleteAll();
			bookRepository.deleteAll();
			
			System.out.println("Saving categories");
			catRepository.save(new Category("Fiction"));
			catRepository.save(new Category("Horror"));
			catRepository.save(new Category("Thriller"));
			catRepository.save(new Category("Autobiography"));
			catRepository.save(new Category("Philosophy"));
			
			System.out.println("Fetching all categories");
			for (Category category : catRepository.findAll()) {
				System.out.println(category);
			}
			
			
			System.out.println("Saving books");
			bookRepository.save(new Book("1984", "George Orwell","XXXXX",1949,9.99, catRepository.findByName("Fiction").get(0)));
			bookRepository.save(new Book("Le Signal", "Maxime Chattam","YYYYY",2018,23.99, catRepository.findByName("Horror").get(0)));
			bookRepository.save(new Book("De L'esprit des lois", "Montesquieu", "ZZZZZ", 1748, 34.55, catRepository.findByName("Philosophy").get(0)));
			
			System.out.println("Fetching all books");
			for (Book book : bookRepository.findAll()) {
				System.out.println(book);
			}
		};
	}
}
