package com.project.bookstore.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class BookRepositoryTest {
	@Autowired
	private BookRepository repository;
	
	@Test
	public void contextLoads() {
		assertThat(repository).isNotNull();
	}
	
	@Test
	public void createNewBook() throws Exception {
		Book book = new Book("Lord of the rings","J.R.R Tolkien","LLLLL",1954,25.6, new Category("Fantasy"));
		repository.save(book);
		assertThat(book.getBookId()).isNotNull();
	}
	
	@Test
	public void findByTitleReturnsBook() throws Exception {
		List<Book> books = repository.findByTitle("1984");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("George Orwell");
	}
	
	@Test
	public void deleteBook() {
		Book book = repository.findByTitle("Lord of the rings").get(0);
		repository.delete(book);
		List<Book> books = repository.findByTitle("Lord of the rings");
		assertThat(books).hasSize(0);
	}
}
