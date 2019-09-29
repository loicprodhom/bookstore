package com.project.bookstore.domain;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book {
	// title, author, year, isbn, price 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long bookId;
	private String title, author, isbn;
	private int year;
	private double price;
	
	@ManyToOne
	@JsonIgnore
    @JoinColumn(name = "category_id")
	private Category category;
	
	public Book() {}
	
	public Book(String title, String author, String isbn, int year, double price, Category category) {
		super();
		this.title=title;
		this.author=author;
		this.isbn=isbn;
		this.year=year;
		this.price=price;
		this.category=category;
	}
	
	public Book(String title, String author, String isbn, int year) {
		super();
		this.title=title;
		this.author=author;
		this.isbn=isbn;
		this.year=year;
	}
	
	public long getBookId() {
		return bookId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public int getYear() {
		return year;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setBookId(long book_id) {
		this.bookId = book_id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
	@Override
	public String toString() {
		return "Book book_id="+bookId+", title="+title+", author="+author+", isbn="+isbn+", year="+year+", price="+price;
	}
}
