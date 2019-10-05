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
public class CategoryRepositoryTest {
	@Autowired
	private CategoryRepository repository;
	
	@Autowired 
	private BookRepository bookRepository;
	
	@Test
	public void contextLoads() {
		assertThat(repository).isNotNull();
	}
	
	@Test
	public void createNewCategory() {
		Category category = new Category("Fantasy");
		repository.save(category);
		assertThat(category.getCategoryId()).isNotNull();
	}
	
	@Test
	public void findByNameReturnsCategory() {
		List<Category> categories = repository.findByName("Horror");
		assertThat(categories).hasSize(1);
		assertThat(categories.get(0).getName()).isEqualTo("Horror");
		Book book = bookRepository.findByTitle("Le Signal").get(0);
		assertThat(categories.get(0).getBooks()).contains(book);
	}
	
	@Test
	public void deleteCategory() {
		Category category = repository.findByName("Autobiography").get(0);
		repository.delete(category);
		List<Category> categories = repository.findByName("Autobiography");
		assertThat(categories).hasSize(0);
	}
}
