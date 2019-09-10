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
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			repository.save(new Book("1984", "George Orwell","XXXXX",1984,9.99));
			repository.save(new Book("Le Signal", "Maxime Chattam","YYYYY",2018,23.99));
		};
	}

}
